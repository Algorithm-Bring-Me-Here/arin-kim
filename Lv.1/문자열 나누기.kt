package Lv.`1`

fun solution(s: String): Int {
    var answer = 0
    var i = 0

    while (i < s.length) {
        var xCount = 0
        var otherCount = 0
        val x = s[i]

        while (i < s.length) {
            if (s[i] == x) {
                xCount++
            } else {
                otherCount++
            }

            i++

            if (xCount == otherCount) {
                answer++
                break
            }
        }
    }

    if (i == s.length) answer++

    return answer
}
