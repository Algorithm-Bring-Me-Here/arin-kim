package Lv.`1`

fun solution(answers: IntArray): IntArray {
    val student1 = arrayOf(1, 2, 3, 4, 5)
    val student2 = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val student3 = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val scores = intArrayOf(0, 0, 0)

    for (i in answers.indices) {
        if (answers[i] == student1[i % student1.size]) scores[0]++
        if (answers[i] == student2[i % student2.size]) scores[1]++
        if (answers[i] == student3[i % student3.size]) scores[2]++
    }

    val maxScore = scores.maxOrNull() ?: 0

    val answer = mutableListOf<Int>()
    for (i in scores.indices) {
        if (scores[i] == maxScore) {
            answer.add(i + 1)
        }
    }

    return answer.toIntArray()
}
