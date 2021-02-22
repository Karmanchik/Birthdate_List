package app.nocamelstyle.birthdatelist.ui.fulllist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.App
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.databinding.FragmentAllEventsBinding
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.ui.EventsAdapter
import app.nocamelstyle.birthdatelist.utils.FragmentModule

class AllEventsFragment : FragmentModule<FragmentAllEventsBinding>() {

    override fun onStart() {
        super.onStart()
        dataBinding.item?.update()
    }

    override fun bindViews(view: View, savedInstanceState: Bundle?) {
        dataBinding.item = AllEventsViewModel()
        dataBinding.item?.events?.observe({lifecycle}, ::showList)
    }

    private fun showList(list: List<Event>) {
        dataBinding.eventsList.adapter = EventsAdapter(list)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_all_events

}