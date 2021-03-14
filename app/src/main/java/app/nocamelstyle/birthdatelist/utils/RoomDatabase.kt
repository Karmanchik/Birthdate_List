package app.nocamelstyle.birthdatelist.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import app.nocamelstyle.birthdatelist.models.Event


@Database(entities = [Event::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun eventsDao(): RoomDao?
}