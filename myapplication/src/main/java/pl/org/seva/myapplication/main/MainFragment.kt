package pl.org.seva.myapplication.main

import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding
import java.text.SimpleDateFormat

class MainFragment : Fragment(R.layout.fr_main) {

    private lateinit var binding: FrMainBinding

    private val data = MutableLiveData(0)

    private val flow = MutableStateFlow(0)

    val ftv: FadingTextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FrMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        decode("WlhsS2FHSkhZMmxQYVVwSlZYcEpNVTVwU1hOSmJsSTFZME5KTmtscmNGaFdRMG81TG1WNVNubGlNbmhzU1dwdmFWVnJWa2hUVms1VlVsWktSbEpEU1hOSmJXeG9aRU5KTmsxVVdUQk5WR3N6VFdwUk0wOURkMmxhV0doM1NXcHZlRTVxWTNwT1ZFRTBUa1JqTkdaUkxsQnJSMmt4WlU0M0xVRnVWSGN5YTA5c2JISkVVazB3V1VsMU4xOXJUbVJDYjE5eVJqWmhiRGhHVTBFPTpZVFUzWXpaalpXSTROalEzTjJObU1nPT0=")


    }

    private fun decode(str: String) {
        val a = String(Base64.decode(str, Base64.NO_WRAP))
        val b = a.substring(0, a.indexOf(":"))
        println("wiktor $a")
        println("wiktor $b")
        val c = String(Base64.decode(b, Base64.NO_WRAP))
        println("wiktor decoded token: $c")
    }
}
