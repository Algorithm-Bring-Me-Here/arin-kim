import kotlin.math.abs

class Solution {
    private val leftKeys = intArrayOf(1, 4, 7, 10)
    private val rightKeys = intArrayOf(3, 6, 9, 12)
    private var currentPosition = intArrayOf(10, 12)

    fun solution(numbers: IntArray, hand: String): String {
        var result = StringBuilder()

        numbers.forEach { number ->
            result.append(
                when (number) {
                    in leftKeys -> moveLeftThumb(number)
                    in rightKeys -> moveRightThumb(number)
                    else -> chooseHand(number, hand)
                }
            )
        }

        return result.toString()
    }

    private fun moveLeftThumb(position: Int): String {
        currentPosition[0] = position
        return "L"
    }

    private fun moveRightThumb(position: Int): String {
        currentPosition[1] = position
        return "R"
    }

    private fun chooseHand(number: Int, preferredHand: String): String {
        val target = if (number == 0) 11 else number

        val leftDistance = calculateDistance(currentPosition[0], target)
        val rightDistance = calculateDistance(currentPosition[1], target)

        return when {
            leftDistance < rightDistance -> moveLeftThumb(target)
            rightDistance < leftDistance -> moveRightThumb(target)
            else -> if (preferredHand == "left") moveLeftThumb(target) else moveRightThumb(target)
        }
    }

    private fun calculateDistance(from: Int, to: Int): Int {
        val rowDistance = abs((from - 1) / 3 - (to - 1) / 3)
        val colDistance = abs((from - 1) % 3 - (to - 1) % 3)
        return rowDistance + colDistance
    }
}
