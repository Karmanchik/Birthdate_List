package app.nocamelstyle.birthdatelist.ui.create

import android.os.Bundle
import android.view.View
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
                    dateView.text = formattedDate
                    date = selectedDate.time / 1000
                }
            }

            saveView.setOnClickListener {
                saveEvent()
            }
        }
    }

    fun saveEvent() {
        dataBinding.apply {
            val event = item?.apply { unixtime = date } ?: return
            GlobalScope.launch {
                App.database?.eventsDao()?.insert(event)
            }
            //App.setting.addEvent(event)
            toast("Saved")
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_create_event

}