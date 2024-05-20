package kotlin_2

class Solution2 {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { n ->
            (n.inv() and n + 1).let{ n or it and (it shr 1).inv() }
        }.toLongArray()
    }
}