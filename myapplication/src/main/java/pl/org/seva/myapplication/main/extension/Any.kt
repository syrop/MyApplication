package pl.org.seva.myapplication.main.extension

import pl.org.seva.myapplication.main.instance
import pl.org.seva.myapplication.main.value
import java.util.logging.Logger

val Any.log: Logger get() = instance<String, Logger>(arg = this::class.java.name).value