package pl.org.seva.myapplication.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import pl.org.seva.myapplication.R

const val NOTIFICATION_CHANNEL_ID = "notifications"
const val NOTIFICATION_CHANNEL_NAME = "notifications"

fun createNotificationChannels(ctx: Context) {
    val notificationManager =
            ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT)
    channel.setSound(null, null)

    notificationManager.createNotificationChannel(channel)
}

fun notify(ctx: Context, title: String, content: String) {
    val notificationManager =
            ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val notificationLayoutExpanded = RemoteViews(ctx.packageName, R.layout.notification_large)

    val notificationBuilder = NotificationCompat.Builder(ctx, NOTIFICATION_CHANNEL_NAME)

    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setStyle(NotificationCompat.BigTextStyle().bigText(content))
            .setLargeIcon(BitmapFactory.decodeResource(ctx.resources, R.drawable.eye))
            .setAutoCancel(true)

    notificationManager.notify(0, notificationBuilder.build())
}
