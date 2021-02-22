package app.nocamelstyle.birthdatelist.ui.fulllist

import androidx.lifecycle.MutableLiveData
import app.nocamelstyle.birthdatelist.App
import app.nocamelstyle.birthdatelist.models.Event

class AllEventsViewModel {

    val events = MutableLiveData<List<Event>>()

    fun update() {
        events.value = App.setting.events
    }

}