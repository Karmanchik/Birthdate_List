package app.nocamelstyle.birthdatelist.models

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Event(
    var personName: String = "",
    var unixtime: Long = 0,
    var description: String = ""
) {
    @SuppressLint("SimpleDateFormat")
    fun getFormattedDate(): String =
        SimpleDateFormat("dd/MM/yyyy").format(Date(unixtime * 1000))
}