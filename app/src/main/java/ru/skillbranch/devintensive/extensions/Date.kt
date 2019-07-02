package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.humanizeDiff(date: Date = Date()): String
{
    val diffMilsec:Long = date.time - this.time
    return when {
        diffMilsec > 360 * DAY -> "более года назад"
        diffMilsec < -360 * DAY -> "более чем через год"
        diffMilsec > 26 * HOUR -> {
            val days: Int = (diffMilsec.toFloat() / DAY.toFloat()).roundToInt()
            "$days ${plural(days, "день", "дня", "дней")} назад"
        }
        diffMilsec < -26 * HOUR -> {
            val days: Int = (diffMilsec.toFloat() / DAY.toFloat()).roundToInt()
            "через ${-days} ${plural(-days, "день", "дня", "дней")}"
        }
        diffMilsec > 22 * HOUR -> "день назад"
        diffMilsec < -22 * HOUR -> "через день"
        diffMilsec > 75 * MINUTE -> {
            val hours: Int = (diffMilsec.toFloat() / HOUR.toFloat()).roundToInt()
            "$hours ${plural(hours, "час", "часа", "часов")} назад"
        }
        diffMilsec < -75 * MINUTE -> {
            val hours: Int = (diffMilsec.toFloat() / HOUR.toFloat()).roundToInt()
            "через ${-hours} ${plural(-hours, "час", "часа", "часов")}"
        }
        diffMilsec > 45 * MINUTE -> "час назад"
        diffMilsec < -45 * MINUTE -> "через час"
        diffMilsec > 75 * SECOND -> {
            val minutes: Int = (diffMilsec.toFloat() / MINUTE.toFloat()).roundToInt()
            "$minutes ${plural(minutes, "минута", "минуты", "минут")} назад"
        }
        diffMilsec < -75 * SECOND -> {
            val minutes: Int = (diffMilsec.toFloat() / MINUTE.toFloat()).roundToInt()
            "через ${-minutes} ${plural(-minutes, "минута", "минуты", "минут")}"
        }
        diffMilsec > 45 * SECOND -> "минуту назад"
        diffMilsec < -45 * SECOND -> "через минуту"
        diffMilsec > 1 * SECOND -> "несколько секунд назад"
        diffMilsec < -1 * SECOND -> "через несколько секунд"
        else -> "только что"
    }
}

fun plural(value: Int, single: String, few: String, many: String): String
{
    return when {
        value % 10 == 0 -> many
        value in 11..19 -> many
        value % 10 == 1 -> single
        value % 10 in 1..4 -> few
        else -> many
    }
}


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
