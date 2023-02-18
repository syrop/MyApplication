package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.BuildConfig
import pl.org.seva.myapplication.databinding.FrMainBinding
import kotlin.coroutines.EmptyCoroutineContext

class MainFragment : Fragment() {

    private lateinit var binding: FrMainBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        binding = FrMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.prompt.text = BuildConfig.VERSION_NAME

        CoroutineScope(EmptyCoroutineContext).launch {
            println("wiktor 42: " + SecuredSharedPreferences.getInstance().getInt("a", -1))
            SecuredSharedPreferences.getInstance().edit().putInt("a", 42).apply()
        }
    }

}
