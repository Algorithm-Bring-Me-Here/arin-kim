package Lv.`2`

class Solution {
    fun solution(s: String): IntArray {
        var count = 0
        var zeroCount = 0
        var currentString = s

        while (currentString != "1") {
            val zeros = currentString.count { it == '0' }
            zeroCount += zeros

            val length = currentString.length - zeros

            currentString = Integer.toBinaryString(length)

            count++
        }

        return intArrayOf(count, zeroCount)
    }
}
