package Lv.`1`

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0

        // 배열 정렬하기
        score.sortDescending()

        for (i in score.indices) {
            if ((i + 1) % m == 0) {
                answer += score[i] * m
            }
        }

        return answer
    }
}