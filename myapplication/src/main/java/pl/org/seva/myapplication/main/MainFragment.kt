package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        flowOf(1, 2, 3).map { 2 }.buffer()

    }
}
