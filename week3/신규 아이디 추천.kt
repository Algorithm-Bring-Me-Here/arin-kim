package week3

class Solution {
    fun solution(newId: String): String {
        var id = newId.lowercase()
        id = id.filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }

        while (".." in id) {
            id = id.replace("..", ".")
        }

        id = id.trim('.')

        if (id.isEmpty()) {
            id = "a"
        }

        if (id.length >= 16) {
            id = id.substring(0, 15).trim('.')
        }

        while (id.length <= 2) {
            id += id.last()
        }

        return id
    }
}
