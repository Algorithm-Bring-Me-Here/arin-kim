package Lv.`1`

class Solution5 {
    fun solution(videoLen: String, pos: String, opStart: String, opEnd: String, commands: Array<String>): String {
        fun timeToSeconds(time: String): Int {
            val parts = time.split(":")
            return parts[0].toInt() * 60 + parts[1].toInt()
        }

        fun secondsToTime(seconds: Int): String {
            val minutes = seconds / 60
            val secs = seconds % 60
            return String.format("%02d:%02d", minutes, secs)
        }

        val videoLength = timeToSeconds(videoLen)
        val openingStart = timeToSeconds(opStart)
        val openingEnd = timeToSeconds(opEnd)
        var currentPosition = timeToSeconds(pos)

        if (currentPosition in openingStart..openingEnd) {
            currentPosition = openingEnd
        }

        for (command in commands) {
            when (command) {
                "prev" -> {
                    currentPosition = (currentPosition - 10).coerceAtLeast(0)
                }
                "next" -> {
                    currentPosition = (currentPosition + 10).coerceAtMost(videoLength)
                }
            }

            if (currentPosition in openingStart..openingEnd) {
                currentPosition = openingEnd
            }
        }

        return secondsToTime(currentPosition)
    }
}
