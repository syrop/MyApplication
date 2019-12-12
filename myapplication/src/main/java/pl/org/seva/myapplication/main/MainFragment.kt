package pl.org.seva.myapplication.main

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R
import android.util.DisplayMetrics
import java.util.*

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val ch = BroadcastChannel<Boolean>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val metrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(metrics)
        val heightPixels: Int = metrics.heightPixels
        val widthPixels: Int = metrics.widthPixels
        val densityStr = when (metrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> "ldpi"
            DisplayMetrics.DENSITY_MEDIUM -> "mdpi"
            DisplayMetrics.DENSITY_HIGH -> "hdpi"
            DisplayMetrics.DENSITY_XHIGH -> "xhdpi"
            DisplayMetrics.DENSITY_XXHIGH -> "xxhdpi"
            DisplayMetrics.DENSITY_XXXHIGH -> "xxxhdpi"
            else -> "unknown"
        }
        val screenScr = "$widthPixels*$heightPixels-$densityStr"

        val locale = Locale.getDefault()
        val language = locale.toLanguageTag().substring(0, 2).toUpperCase(locale)
        val json = "{\"Android\", \"${Build.VERSION.RELEASE}\", \"$language\", \"$screenScr\"}"

        println("wiktor $json")
    }
}
