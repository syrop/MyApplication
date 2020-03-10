package pl.org.seva.myapplication.main.extension

import kotlinx.coroutines.suspendCancellableCoroutine
import rx.Observable
import rx.Observer
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> Observable<T>.awaitSingle() = suspendCancellableCoroutine<T> { cont ->

    val subscription = subscribe(object : Observer<T> {
        private var value: T? = null
        private var seenValue = false

        override fun onError(e: Throwable) {
            cont.resumeWithException(e)
        }

        override fun onNext(t: T) {
            if (seenValue) {
                if (cont.isActive)
                    cont.resumeWithException(IllegalArgumentException("More than one onNext value"))
            } else {
                value = t
                seenValue = true
            }
        }

        override fun onCompleted() {
            if (seenValue) {
                if (cont.isActive) cont.resume(value!!)
                return
            }
            when {
                cont.isActive -> {
                    cont.resumeWithException(NoSuchElementException("No value received via onNext"))
                }
            }
        }
    })

    cont.invokeOnCancellation { subscription.unsubscribe() }
}
