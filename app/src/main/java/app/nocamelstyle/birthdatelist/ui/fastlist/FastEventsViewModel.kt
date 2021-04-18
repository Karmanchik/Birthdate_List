package app.nocamelstyle.birthdatelist.ui.fastlist

import androidx.lifecycle.MutableLiveData
import app.nocamelstyle.birthdatelist.App
import app.nocamelstyle.birthdatelist.models.Event
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class FastEventsViewModel {

    val events = MutableLiveData<List<Event>>()

    fun update() {
        val min = Date().time / 1000
        val max = min + 7 * 24 * 60 * 60

        GlobalScope.launch {
            events.postValue(App.database?.eventsDao()?.getFromPeriod(min, max))
        }
    }

}