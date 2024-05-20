package kotlin_1

import kotlin_2.Solution

fun main() {
    Solution().solution(5, intArrayOf(1,2), intArrayOf(3))
}

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        var lostList = (lost.sorted() - reserve.sorted()).toMutableList()
        var reserveList = (reserve.sorted() - lost.sorted()).toMutableList()
        answer = n - lostList.size

        for (i in lostList) {
            if (reserveList.contains(i - 1)) {
                reserveList.remove(i - 1)
                answer += 1
            } else if (reserveList.contains(i + 1)) {
                reserveList.remove(i + 1)
                answer += 1
            }
        }

        return answer
    }
}