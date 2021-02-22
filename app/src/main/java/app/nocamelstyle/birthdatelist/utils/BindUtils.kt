package app.nocamelstyle.birthdatelist.utils

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import app.nocamelstyle.birthdatelist.models.Event
import app.nocamelstyle.birthdatelist.ui.EventsAdapter

object BindUtils {

    @JvmStatic
    @BindingAdapter("list")
    fun setList(view: RecyclerView?, list: MutableLiveData<List<Event>>) {
        view?.adapter = EventsAdapter(list.value ?: listOf())
    }

}