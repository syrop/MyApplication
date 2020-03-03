package pl.org.seva.myapplication.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import pl.org.seva.myapplication.R

const val NOTIFICATION_CHANNEL_ID = "notifications"
const val NOTIFICATION_CHANNEL_NAME = "notifications"
const val NOTIFICATION_DELETE = "notification_delete"

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

fun notify(ctx: Context, content: String) {
    val notificationManager =
            ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val notificationBuilder = Notification.Builder(ctx, NOTIFICATION_CHANNEL_NAME)

    val deleteIntent = Intent(NOTIFICATION_DELETE)
    val pi = PendingIntent.getBroadcast(
            ctx,
            System.currentTimeMillis().toInt(),
            deleteIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)

    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Title")
            .setContentText(content)
            .setAutoCancel(true)
            .setDeleteIntent(pi)

    notificationManager.notify(0, notificationBuilder.build())
}
