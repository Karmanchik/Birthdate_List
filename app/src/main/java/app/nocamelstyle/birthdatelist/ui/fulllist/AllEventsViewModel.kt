package app.nocamelstyle.birthdatelist.ui.fulllist

import androidx.lifecycle.MutableLiveData
import app.nocamelstyle.birthdatelist.App
import app.nocamelstyle.birthdatelist.models.Event
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AllEventsViewModel {

    val events = MutableLiveData<List<Event>>()

    fun update() {
        GlobalScope.launch {
            events.postValue(App.database?.eventsDao()?.getAll())//App.setting.events
        }
    }

}