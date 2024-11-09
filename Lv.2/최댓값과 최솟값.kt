package Lv.`2`

fun solution(s: String): String {
    val numbers = s.split(" ").map { it.toInt() }

    val min = numbers.minOrNull() ?: 0
    val max = numbers.maxOrNull() ?: 0

    return "$min $max"
}