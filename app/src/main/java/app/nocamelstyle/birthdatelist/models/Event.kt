package app.nocamelstyle.birthdatelist.models

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var personName: String = "",
    var unixtime: Long = 0,
    var description: String = ""
) {
    @SuppressLint("SimpleDateFormat")
    fun getFormattedDate(): String =
        SimpleDateFormat("dd/MM/yyyy").format(Date(unixtime * 1000))

    fun isEmpty(): Boolean =
        personName.isEmpty() || description.isEmpty() || unixtime == 0L

}