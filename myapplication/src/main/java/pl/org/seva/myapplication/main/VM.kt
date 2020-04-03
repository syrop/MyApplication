package pl.org.seva.myapplication.main

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.net.URL

class VM : ViewModel() {

    private val bitmapCh = Channel<Bitmap>(Channel.CONFLATED)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            bitmapCh.send(BitmapFactory.decodeStream(URL(IMAGE_URL).openStream()))
        }
    }

    suspend fun getBitmap() = bitmapCh.receive()

    companion object {
        const val IMAGE_URL = "https://www.getmorebrain.com/wp-content/uploads/2019/03/laptop.png"
    }
}
