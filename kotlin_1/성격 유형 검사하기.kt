package kotlin_1

class Solution2 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        val kbti = charArrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
        var score = IntArray(8) { 0 }


        for (i in survey.indices) {
            score[kbti.indexOf(survey[i][1])] += choices[i] - 4
        }
        for (i in 0..7 step 2) {
            if (score[i] >= score[i + 1]) answer += kbti[i]
            else answer += kbti[i + 1]
        }

        return answer
    }
}