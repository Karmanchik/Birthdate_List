package app.nocamelstyle.birthdatelist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.databinding.ItemEventBinding
import app.nocamelstyle.birthdatelist.models.Event

class EventsAdapter(var events: List<Event>) : RecyclerView.Adapter<EventsAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(events[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        return Holder(ItemEventBinding.inflate(inflater))
    }

    override fun getItemCount(): Int =
        events.size

    inner class Holder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) = binding.apply {
            item = event
            executePendingBindings()
        }
    }

}