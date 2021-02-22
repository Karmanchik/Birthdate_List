package app.nocamelstyle.birthdatelist.ui.create

import android.os.Bundle
import android.view.View
import app.nocamelstyle.birthdatelist.*
import app.nocamelstyle.birthdatelist.databinding.FragmentCreateEventBinding
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.utils.FragmentModule


class CreateEventFragment : FragmentModule<FragmentCreateEventBinding>() {

    override fun bindViews(view: View, savedInstanceState: Bundle?) {
        var date: Long = 0

        dataBinding.apply {
            item = Event()

            dateView.setOnClickListener {
                requireContext().getDateFromDateDialog { selectedDate, formattedDate ->
                    dateView.text = formattedDate
                    date = selectedDate.time / 1000
                }
            }

            saveView.setOnClickListener {
                val event = item?.apply { unixtime = date } ?: return@setOnClickListener
                App.setting.addEvent(event)
                toast("Saved")
            }
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_create_event

}