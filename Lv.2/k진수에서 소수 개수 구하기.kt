package Lv.`2`

fun solution(n: Int, k: Int): Int {
    val converted = n.toString(k)
    val parts = converted.split("0")
    var count = 0

    for (part in parts) {
        if (part.isNotEmpty() && checkPrime(part.toLong())) {
            count++
        }
    }

    return count
}

fun checkPrime(num: Long): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toLong()) {
        if (num % i == 0L) return false
    }
    return true
}