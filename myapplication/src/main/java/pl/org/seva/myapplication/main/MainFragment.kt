package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    private val vm by viewModels<VM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            notify(
                requireContext(),
                getString(R.string.lorem_ipsum_title),
                getString(R.string.lorem_ipsum),
                vm.getBitmap(),
            )
        }
    }
}
