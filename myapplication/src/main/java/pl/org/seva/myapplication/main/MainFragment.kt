package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fr_main) {

    private val array = Array(SIZE) { 0 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        generate {
            repeat(SIZE) {
                array[it] = Random.nextInt(RANGE)
            }
            unsorted.text = array.contentToString()
        }

        sort {
            for (i in SIZE - 1 downTo 0) {
                repeat(i) { j ->
                    if (array[j] > array[j + 1]) {
                        val temp = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = temp
                    }
                }
            }
            sorted.text = array.contentToString()
        }
    }

    companion object {
        const val RANGE = 1024
        const val SIZE = 5
    }
}
