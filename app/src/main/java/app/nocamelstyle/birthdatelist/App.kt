package app.nocamelstyle.birthdatelist

import android.app.Application
import androidx.room.Room
import app.nocamelstyle.birthdatelist.utils.RoomDatabase
import app.nocamelstyle.birthdatelist.utils.Setting


class App : Application() {

    companion object {
        var database: RoomDatabase? = null
        lateinit var setting: Setting
    }

    override fun onCreate() {
        super.onCreate()
        setting = Setting(applicationContext)
        database = Room.databaseBuilder(this, RoomDatabase::class.java, "database")
            .build()
    }

}