package pl.org.seva.myapplication.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
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

fun notify(ctx: Context, title: String, content: String, bitmap: Bitmap? = null) {
    val notificationManager =
            ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val notificationBuilder = NotificationCompat.Builder(ctx, NOTIFICATION_CHANNEL_NAME)

    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setStyle(NotificationCompat.BigTextStyle().bigText(content))
            .setAutoCancel(true)

    if (bitmap != null) {
        notificationBuilder.setLargeIcon(bitmap)
    }

    notificationManager.notify(0, notificationBuilder.build())
}
