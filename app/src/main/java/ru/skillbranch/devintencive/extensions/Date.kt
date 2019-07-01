package ru.skillbranch.devintencive.extensions

import java.text.SimpleDateFormat
import java.util.*


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.humanizeDiff(toDate: Date = Date()): String? {
    var time = this.time
    if (time < 1000000000000L) {
        // if timestamp given in seconds, convert to millis
        time *= 1000
    }

    val now = toDate.time
    if (time > now || time <= 0) {
        return null
    }

    val diff = now - time
    println(this.format())
    return if (diff < MINUTE) {
        "только что"
    } else if (diff < 2 * MINUTE) {
        "минуту назад"
    } else if (diff < 50 * MINUTE) {
        (diff / MINUTE).toString() + " минуты назад"
    } else if (diff < 90 * MINUTE) {
        "час назад"
    } else if (diff < 24 * HOUR) {
        (diff / HOUR).toString() + " часа назад"
    } else if (diff < 48 * HOUR) {
        "вчера"
    } else {
        (diff / DAY).toString() + " дней назад"
    }
}




fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnit = TimeUnit.SECOND): Date {
    var time = this.time

    println(time)

    time += when (units) {
        TimeUnit.SECOND -> value * SECOND
        TimeUnit.MINUTE -> value * MINUTE
        TimeUnit.HOUR -> value * HOUR
        TimeUnit.DAY -> value * DAY
    }

    println(time)

    this.time = time
    return this
}

enum class TimeUnit {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
