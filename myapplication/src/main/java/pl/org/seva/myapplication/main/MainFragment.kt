package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import kotlinx.coroutines.rx2.awaitSingle
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.awaitSingle
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav
import rx.Observable

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }

        lifecycleScope.launch {
            val a = checkNotNull(Observable.just(1).awaitSingle())
            println("wiktor received value $a")
        }

        lifecycleScope.launch {
            val subject = PublishSubject.create<Int>().awaitSingle()

            val a = Single.just(1).await()
        }
    }
}
