package pl.org.seva.myapplication.main.init

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.FutureTask
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * Credit: https://github.com/Kotlin/kotlinx.coroutines/issues/1617#issuecomment-1044365112
 */
object PriorityExecutor {

    private val priorityDispatcher = PriorityDispatcher()

    internal class PriorityDispatcher : CoroutineDispatcher() {

        private val priorityExecutor = ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            PriorityBlockingQueue(100000),
        )

        override fun dispatch(context: CoroutineContext, block: Runnable) {
            val priority = context[CoroutinePriority]?.priority ?: return
            val executable = RunWithPriorityFuture(RunWithPriority(block, priority))
            priorityExecutor.execute(executable)
        }

    }

    internal data class CoroutinePriority(
        val priority: StateFlow<Int>
    ) : AbstractCoroutineContextElement(CoroutinePriority) {
        companion object Key : CoroutineContext.Key<CoroutinePriority>

        override fun toString(): String = "CoroutinePriority($priority)"
    }

    internal class RunWithPriority(val runnable: Runnable, val priority: StateFlow<Int>) : Runnable {

        override fun run() {
            runnable.run()
        }
    }

    internal class RunWithPriorityFuture(private val runWithPriority: RunWithPriority) :
        FutureTask<RunWithPriorityFuture>(runWithPriority.runnable, null), Comparable<RunWithPriorityFuture> {

        override fun compareTo(other: RunWithPriorityFuture): Int {
            return other.runWithPriority.priority.value - runWithPriority.priority.value
        }

    }

    fun submitAction(priority: StateFlow<Int>, runnable: suspend () -> Unit): Job {
        return CoroutineScope(priorityDispatcher).launch(CoroutinePriority(priority)) {
            runnable.invoke()
        }
    }

}
