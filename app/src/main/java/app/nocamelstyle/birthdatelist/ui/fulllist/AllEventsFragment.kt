package app.nocamelstyle.birthdatelist.ui.fulllist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.R
import app.nocamelstyle.birthdatelist.Setting
import app.nocamelstyle.birthdatelist.models.Event
import java.text.SimpleDateFormat
import java.util.*

class AllEventsFragment : Fragment(R.layout.fragment_all_events) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<RecyclerView>(R.id.eventsList)?.adapter = EventsAdapter(
            Setting(requireContext()).events
        )
    }


}

class EventsAdapter(var events: List<Event>) : RecyclerView.Adapter<EventsAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nameView.text = events[position].personName
        holder.description.text = events[position].description
        holder.dateView.text = SimpleDateFormat("dd/MM/yyyy").format(Date(events[position].unixtime * 1000))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        return Holder(inflater.inflate(R.layout.item_event, parent, false))
    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView = view.findViewById<TextView>(R.id.textView2)
        val dateView = view.findViewById<TextView>(R.id.textView3)
        val description = view.findViewById<TextView>(R.id.textView4)
    }

}