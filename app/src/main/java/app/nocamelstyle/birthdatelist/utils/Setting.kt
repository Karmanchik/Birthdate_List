package app.nocamelstyle.birthdatelist.utils

import android.content.Context
import androidx.core.content.edit
import app.nocamelstyle.birthdatelist.models.Event
import com.google.gson.Gson

class Setting(ctx: Context) {

    private val pref by lazy { ctx.getSharedPreferences("setting", Context.MODE_PRIVATE) }

    var events: List<Event>
        get() = pref.getStringSet("events", setOf())!!
            .mapNotNull { Gson().fromJson(it, Event::class.java) }
        set(value) = pref.edit {
            putStringSet("events", value.map { Gson().toJson(it) }.toSet())
        }

    fun addEvent(event: Event) {
        events = events + event
    }


}