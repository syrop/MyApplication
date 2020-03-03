package pl.org.seva.myapplication.main.init

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatDelegate
import pl.org.seva.myapplication.main.NOTIFICATION_DELETE
import pl.org.seva.myapplication.main.createNotificationChannels


class Bootstrap {

    fun boot(ctx: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        createNotificationChannels(ctx)
        ctx.registerReceiver(NotificationBroadcastReceiver(), IntentFilter(NOTIFICATION_DELETE))
    }

    class NotificationBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            println("wiktor notification deleted")
        }
    }
}
