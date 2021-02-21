package app.nocamelstyle.birthdatelist.ui.fulllist

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.ui.EventsAdapter
import app.nocamelstyle.birthdatelist.utils.Setting

class AllEventsFragment : Fragment(R.layout.fragment_all_events) {

    override fun onStart() {
        super.onStart()
        view?.findViewById<RecyclerView>(R.id.eventsList)?.adapter = EventsAdapter(
                Setting(requireContext()).events
        )
    }

}