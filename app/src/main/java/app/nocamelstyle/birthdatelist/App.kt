package app.nocamelstyle.birthdatelist

import android.app.Application
import app.nocamelstyle.birthdatelist.utils.Setting

class App : Application() {

    companion object {
        lateinit var setting: Setting
    }

    override fun onCreate() {
        super.onCreate()
        setting = Setting(applicationContext)
    }

}