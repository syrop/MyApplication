package pl.org.seva.myapplication.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }
        sound {
            val mp = MediaPlayer.create(requireContext(), R.raw.knock_fingers_on_the_table)
            mp.setOnCompletionListener {
                it.release()
            }
            mp.start()
        }
        lifecycleScope.launch {
            createChannel()
            createChannel(true)
            delay(1000)
            sendNotification(false)
            delay(10000)
            sendNotification(sound = true)
        }
    }

    private fun sendNotification(sound: Boolean = true) {
        val channelName = "$CHANNEL_NAME$sound"
        val notificationBuilder = Notification.Builder(requireContext(), channelName)
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Lorem ipsum")
                .setAutoCancel(true)

        val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }

    private fun createChannel(sound: Boolean = true) {
        val name = "$CHANNEL_NAME$sound"
        val channel = NotificationChannel(
                name,
                getString(R.string.app_name),
                NotificationManager.IMPORTANCE_DEFAULT)
        val uri =
                if (sound) {
                    Uri.parse("android.resource://" +
                            requireContext().packageName + "/" + R.raw.knock_fingers_on_the_table)
                }
                else null
        channel.setSound(uri, null)

        val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun deleteChannel() {
        val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.deleteNotificationChannel(CHANNEL_NAME)
    }

    companion object {
        private const val CHANNEL_NAME = "channel"
    }
}
