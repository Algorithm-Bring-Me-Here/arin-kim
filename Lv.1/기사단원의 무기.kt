package Lv.`1`

class Solution4 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (i in 1..number) {
            var divisorCount = 0

            for (j in 1..Math.sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    divisorCount += 1
                    if (j != i / j) {
                        divisorCount += 1
                    }
                }
            }

            if (divisorCount > limit) {
                answer += power
            } else {
                answer += divisorCount
            }
        }

        return answer
    }
}
