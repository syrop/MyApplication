package pl.org.seva.myapplication.main.init

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import pl.org.seva.myapplication.main.createNotificationChannels


class Bootstrap {

    lateinit var context: Context

    fun boot(ctx: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        createNotificationChannels(ctx)
    }
}
