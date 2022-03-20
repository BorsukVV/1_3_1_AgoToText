package ru.netology

val measureMinutes = "мин."
val measureHours = "час"

fun main() {
    val lastOnlineSeconds = 0
    val currentSeconds = 86
    println(agoToText(lastOnlineSeconds, currentSeconds))
    println()
    //значения далее подставлены для демонстрации работы
    println(agoToText(lastOnlineSeconds, 130))
    println()
    println(agoToText(lastOnlineSeconds, 300))
    println()
    println(agoToText(lastOnlineSeconds, 3700))
    println()
    println(agoToText(lastOnlineSeconds, 7300))
    println()
    println(agoToText(lastOnlineSeconds, 18_000))
    println()
    println(agoToText(lastOnlineSeconds, 90_000))
    println()
    println(agoToText(lastOnlineSeconds, 200_000))
    println()
    println(agoToText(lastOnlineSeconds, 300_000))
    println()

}

fun singularPluralDeclension(
    timeCount: Int,
    measure: String = measureMinutes
): String {

    val one: String
    val two: String
    val five: String

    when (measure) {
        measureMinutes -> {
            one = "минуту"
            two = "минуты"
            five = "минут"
        }
        measureHours -> {
            one = "час"
            two = "часа"
            five = "часов"
        }
        else -> {
            val notDefined = "не известно"
            one = notDefined
            two = notDefined
            five = notDefined
        }
    }

    var result = timeCount

    if (result > 20) {
        result %= 10
    }
    return when (result) {
        1 -> one
        in (2 until 5) -> two
        else -> five
    }
}

fun agoToText(lastOnlineSeconds: Int, currentSeconds: Int): String {
    val previousToCurrentDifference = currentSeconds - lastOnlineSeconds
    return when (previousToCurrentDifference) {
        in (0 until 60) -> {
            "Пользователь был только что"
        }
        in (61 until 3600) -> {
            val minutesCount = previousToCurrentDifference / 60
            "Пользователь был $minutesCount ${singularPluralDeclension(minutesCount)} назад"
        }
        in (3601 until 86400) -> {
            val hoursCount = previousToCurrentDifference / 3600
            "Пользователь был $hoursCount ${singularPluralDeclension(hoursCount, measureHours)} назад"
        }
        in (86400 until 172800) -> {
            "Пользователь был сегодня"
        }
        in (172800 until 259200) -> {
            "Пользователь был вчера"
        }
        else -> "Пользователь был давно"
    }
}