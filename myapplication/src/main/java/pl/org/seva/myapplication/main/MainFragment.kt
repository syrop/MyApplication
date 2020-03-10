package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.reactivex.Single
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }

        lifecycleScope.launch {
            val a = Single.just(1).await()

        }
    }
}
