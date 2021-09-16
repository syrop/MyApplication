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
        val casesInPerCent = CASES_TOTAL / PER_CENT
        val all = (casesInPerCent * 100.0).roundToInt()
        val movingAverage = CASES.take(DAYS_EXPONENTIAL).sum() / DAYS_EXPONENTIAL.toDouble()
        println("wiktor moving average: %.0f".format(movingAverage))
        println("wiktor 1 in %.2f".format(oneIn))
        println("wiktor %% per day: %.4f".format(CASES.first() / casesInPerCent))
        val inXDays = CASES_TOTAL + DAYS_LINEAR * CASES.first()
        val perCentInXDays = inXDays / casesInPerCent
        val inXDaysOneIn = 1 / (perCentInXDays / 100.0)
        println("wiktor in $DAYS_LINEAR days 1 in %.2f".format(inXDaysOneIn))
        val daysUntilAll = (casesInPerCent * (100.0 - PER_CENT) / CASES.first()).toInt()
        println("wiktor ${daysUntilAll.toYears()} days until all")
        println("wiktor EXPONENTIAL")
        println("wiktor %% per day: %.3f".format(perCentDaily()))
        println("wiktor %% per $DAYS_EXPONENTIAL days: %.1f".format(perCentInDays(DAYS_EXPONENTIAL)))
        println("wiktor doubling every %.3f days".format(doubling()))
        if (doubling() > 0.0) {
            var cases = CASES_TOTAL

            var day = 0
            while (cases < all) {
                day++
                val perDay = perDay(day)
                cases += perDay
                val perCent = cases.toDouble() / all.toDouble() * 100.0
                println("wiktor day $day daily: $perDay total: %.2f%%".format(perCent))
            }
            println("wiktor ${day.toYears()}: $cases")
        }
    }

    private fun perDay(day: Int): Int {
        val root = 2.0.pow(1.0 / doubling())
        return (CASES.first() * root.pow(day.toDouble())).roundToInt()
    }

    private fun doubling(): Double {
        val perCent = perCentInDays(DAYS_EXPONENTIAL)
        val daily = (perCent / 100.0 + 1.0).pow(1.0 / DAYS_EXPONENTIAL)
        return log(2.0, daily)
    }

    private fun perCentDaily() = perCentInDays(1)

    private fun perCentInDays(days: Int) =
            (CASES[0].toDouble() / CASES[days].toDouble() - 1.0) * 100.0

    private fun Int.toYears() =
            "${(this / DAYS_IN_YEAR).toInt()} years ${(this % DAYS_IN_YEAR).roundToInt()} days"

    @Suppress("SpellCheckingInspection")
    companion object {
        const val CASES_TOTAL = 2_895_223
        const val PER_CENT = 7.68
        const val DAYS_EXPONENTIAL = 1
        // 26_600-28_500: przy takiej średniej z 7 dni będzie narodowa kwarantanna
        val CASES = arrayOf(
            767,
            537,
            269,
            476,
            530,
            528,
            510,
            533,
            406,
            183,
            324,
            389,
            349,
            390,
            366,
            285,
            151,
            204,
            290,
            258,
            251,
            234,
            233,
            107,
            185,
            222,
            212,
            197,
            208,
            221,
            128,
            148,
            211,
            196,
            223,
            198,
            200,
            64,
            122,
            181,
            172,
            176,
            164,
            164,
            91,
            91,
            153,
            153,
            167,
            138,
            106,
            74,
            82,
            122,
            108,
            126,
            124,
            104,
            67,
            69,
            114,
            93,
            105,
            86,
            96,
            44,
            66,
            86,
            76,
            93,
            103,
            96,
            38,
            54,
            107,
            96,
            98,
            104,
            123,
            52,
            71,
            100,
            133,
            147,
            165,
            188,
            73,
            133,
            168,
            190,
            218,
            241,
            215,
            140,
            227,
            239,
            341,
            382,
            428,
            400,
            194,
            312,
            415,
            319,
            572,
            664,
            588,
            333,
            579,
            775,
            946,
            1_230,
            1_267,
            1_000,
            559,
            1_075,
            1_516,
            1_679,
            2_086,
            2_344,
            1_734,
            1_109,
            2_167,
            2_896,
            3_288,
            3_730,
            4_255,
            3_098,
            2_032,
            3_852,
            4_765,
            6_047,
            6_431,
            3_896,
            2_296,
            2_525,
            4_612,
            6_469,
            6_796,
            8_427,
            8_895,
            5_709,
            3_451,
            7_219,
            9_505,
            10_858,
            12_762,
            13_926,
            9_246,
            7_283,
            12_153,
            15_763,
            17_847,
            21_130,
            21_283,
            13_277,
            12_013,
            21_703,
            24_856,
            28_487,
            27_877,
            14_910,
            8_245,
            9_902,
            22_947,
            28_073,
            30_546,
            35_251,
            32_874,
            20_870,
            16_965,
            29_253,
            31_757,
            35_143,
            34_151,
            29_978,
            16_741,
            14_578,
            21_849,
            26_405,
            25_998,
            27_278,
            25_052,
            14_396,
            10_896,
            17_259,
            21_049,
            17_260,
            9_954,
            6_170,
            13_574,
            14_857,
            15_829,
            15_250,
            15_698,
            7_937,
            4_786,
            10_099,
            12_100,
            11_539,
            12_142,
            12_146,
            6_310,
            )
        const val POPULATION = 38_300_357 // 38_300_339, 38_305_109
        const val DAYS_LINEAR = 100
        const val DAYS_IN_YEAR = 365.25
    }
}
