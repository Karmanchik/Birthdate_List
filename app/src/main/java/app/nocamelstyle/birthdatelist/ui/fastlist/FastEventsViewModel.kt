package app.nocamelstyle.birthdatelist.ui.fastlist

import androidx.lifecycle.MutableLiveData
import app.nocamelstyle.birthdatelist.App
import app.nocamelstyle.birthdatelist.models.Event
import java.util.*

class FastEventsViewModel {

    val events = MutableLiveData<List<Event>>()

    fun update() {
        var minimumDate = Calendar.getInstance().timeInMillis / 1000
        minimumDate -= 7 * 24 * 60 * 60
        events.value = App.setting.events.filter { it.unixtime > minimumDate }
    }

}