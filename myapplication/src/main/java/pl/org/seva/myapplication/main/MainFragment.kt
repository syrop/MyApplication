package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.roundToInt

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val oneIn = 1.0 / (PER_CENT / 100.0)
        println("wiktor LINEAR")
        println("wiktor 1 in %.2f".format(oneIn))
        val casesInPerCent = CASES_TOTAL / PER_CENT
        println("wiktor %% per day: %.4f".format(PER_DAY / casesInPerCent))
        val inXDays = CASES_TOTAL + DAYS * PER_DAY
        val perCentInXDays = inXDays / casesInPerCent
        val inXDaysOneIn = 1 / (perCentInXDays / 100.0)
        println("wiktor in $DAYS days 1 in %.2f".format(inXDaysOneIn))
        val daysUntilAll = (casesInPerCent * (100.0 - PER_CENT) / PER_DAY).toInt()
        println("wiktor ${daysUntilAll.toYears()} days until all")
        println("wiktor EXPONENTIAL")
        println("wiktor %% per day: %.3f".format(perCentDaily()))
        println("wiktor doubling every %.3f days".format(doubling()))
        var cases = CASES_TOTAL
        val all = (casesInPerCent * 100.0).roundToInt()
        var day = 0
        while (cases < all) {
            day++
            val perDay = perDay(day)
            cases += perDay
            println("wiktor day $day: $perDay")
        }
        println("wiktor ${day.toYears()}: $cases")
    }

    private fun perDay(day: Int): Int {
        val root = 2.0.pow(1.0 / doubling())
        return (PER_DAY * root.pow(day.toDouble())).roundToInt()
    }

    private fun doubling() = log(2.0, perCentDaily() / 100.0 + 1.0)

    private fun perCentDaily() = ((PER_DAY.toDouble() / YESTERDAY.toDouble()) - 1.0) * 100.0

    private fun Int.toYears() = "${(this / DAYS_IN_YEAR).toInt()} years ${(this % DAYS_IN_YEAR).roundToInt()} days"

    companion object {
        const val PER_DAY = 5_300
        const val YESTERDAY = 4_739
        const val CASES_TOTAL = 121_638
        const val PER_CENT = 0.32

        const val DAYS = 100
        const val DAYS_IN_YEAR = 365.25
        val CASES = arrayOf(
                5_300,
                4_739,
                4_280,
                3_003,
                2_236,
                2_006,
                1_934,
                2_367,
                2_292,
                1_967,
                1_552,
                1_326,
                1_306,
                1_350,
                1_584,
                1_587,
                1_136,
                974,
                711,
                748,
                910,
                1_002,
                757,
                837,
                600,
                605,
                377,
                502,
                603,
                594,
                506,
                421,
                400,
                302,
                437,
                567,
                691,
                612,
                595,
                550,
                502,
                631,
                759,
                791,
                887,
                729,
                )
    }
}
