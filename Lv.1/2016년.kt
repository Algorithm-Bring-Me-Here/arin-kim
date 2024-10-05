package Lv.`1`


fun solution(a: Int, b: Int): String {
    val daysOfMonth = listOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val dayOfWeek = listOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
    val totalDays = (1 until a).sumOf { daysOfMonth[it] } + b - 1

    return dayOfWeek[totalDays % 7]
}