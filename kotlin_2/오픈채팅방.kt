package kotlin_2

class Solution {
    fun solution(record: Int, intArrayOf: IntArray, intArrayOf1: IntArray): Array<Any> {
        var member: MutableMap<String, String> = mutableMapOf()

        record.forEach {
            val str = it.split(" ")
            if (str.size == 3) {
                member.put(str[1], str[2])
            }
        }

        val answer = ArrayList<String>()
        record.forEach {
            val str = it.split(" ")
            if (str[0].equals("Enter")) {
                answer.add("${member.get(str[1])}님이 들어왔습니다.")
            } else if (str[0].equals("Leave")) {
                answer.add("${member.get(str[1])}님이 나갔습니다.")
            }
        }

        return answer.toArray()
    }
}