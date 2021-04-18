package app.nocamelstyle.birthdatelist.ui.createevent

import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import app.nocamelstyle.birthdatelist.*
import app.nocamelstyle.birthdatelist.databinding.FragmentCreateEventBinding
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.utils.FragmentModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CreateEventFragment : FragmentModule<FragmentCreateEventBinding>() {

    var date: Long = 0

    override fun bindViews(view: View, savedInstanceState: Bundle?) {


        dataBinding.apply {
            item = Event()

            dateView.setOnClickListener {
                requireContext().getDateFromDateDialog { selectedDate, formattedDate ->
                    dateView.setText(formattedDate)
                    date = selectedDate.time / 1000
                }
            }

            saveView.setOnClickListener {
                saveEvent()
            }
        }
    }

    private fun saveEvent() {
        dataBinding.apply {
            val event = item?.apply { unixtime = date } ?: return
            if (event.isEmpty()) {
                toast("Заполните все поля!")
                return
            }
            GlobalScope.launch {
                App.database?.eventsDao()?.insert(event)
            }
            toast("Saved")
            camera.launch()
        }
    }

    val camera = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        dataBinding.imageView.setImageBitmap(bitmap)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_create_event

}