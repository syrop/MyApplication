package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R
import kotlin.math.roundToInt

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val oneIn = 1.0 / (PER_CENT / 100.0)
        println("wiktor one in $oneIn")
        val casesInPerCent = CASES_TOTAL / PER_CENT
        println("wiktor one percent: $casesInPerCent")
        val inXDays = CASES_TOTAL + DAYS * PER_DAY
        val perCentInXDays = inXDays / casesInPerCent
        val inXDaysOneIn = 1 / (perCentInXDays / 100.0)
        println("wiktor in $DAYS days 1 in $inXDaysOneIn")
        val daysUntilAll = (casesInPerCent * (100.0 - PER_CENT) / PER_DAY).toInt()
        println("wiktor ${(daysUntilAll / DAYS_IN_YEAR).toInt()} years ${(daysUntilAll % DAYS_IN_YEAR).roundToInt()} days until all")
    }

    companion object {
        const val PER_DAY = 4280
        const val CASES_TOTAL = 111_599
        const val PER_CENT = 0.3
        const val DAYS = 100
        const val DAYS_IN_YEAR = 365.25
    }
}
