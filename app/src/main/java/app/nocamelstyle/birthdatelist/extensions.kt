package app.nocamelstyle.birthdatelist

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ClickableViewAccessibility")
fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
    setOnTouchListener { v, event ->
        var hasConsumed = false
        if (v is EditText) {
            if (event.x >= v.width - v.totalPaddingRight) {
                if (event.action == MotionEvent.ACTION_UP) {
                    onClicked(this)
                }
                hasConsumed = true
            }
        }
        hasConsumed
    }
}

fun Fragment.hideKeyboard() {
    requireActivity().apply {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
        }
    }
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(activity, message, duration).show()

fun Fragment.toast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(activity, messageId, duration).show()

fun Context.getDateFromDateDialog(action: (selectedDate: Date, formattedDate: String) -> Unit) {
    val calendar = Calendar.getInstance()
    val selectCalendar = Calendar.getInstance()
    val d =
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                selectCalendar.set(Calendar.YEAR, year)
                selectCalendar.set(Calendar.MONTH, monthOfYear)
                selectCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val formatDate = "" + selectCalendar.get(Calendar.DAY_OF_MONTH).formatted() +
                        "" + (selectCalendar.get(Calendar.MONTH) + 1).formatted() +
                        "" + selectCalendar.get(Calendar.YEAR)
                action(selectCalendar.time, formatDate)
            }

    DatePickerDialog(
            this,
            d,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
    ).apply {
        datePicker.maxDate = Calendar.getInstance().timeInMillis
    }
            .show()
}

private fun Int.formatted() = if (this < 10) "0$this" else this.toString()

@SuppressLint("SimpleDateFormat")
fun String.reformatDate(inputPattern: String, outputPattern: String): String? {
    val inputFormatter = SimpleDateFormat(inputPattern)
    val outputFormatter = SimpleDateFormat(outputPattern)

    return inputFormatter.parse(this)?.let { outputFormatter.format(it) }
}