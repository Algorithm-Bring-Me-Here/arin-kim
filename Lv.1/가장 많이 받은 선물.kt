package Lv.`1`

fun solution2(users: Array<String>, giftList: Array<String>): Int {
    var result: Int = 0
    val giftTracker = mutableMapOf<String, MutableList<String>>()

    val giftsReceived = mutableMapOf<String, Int>()
    val giftsGiven = mutableMapOf<String, Int>()
    val scoreMap = mutableMapOf<String, Int>()
    val totalGifts = mutableMapOf<String, Int>()

    giftList.forEach { record ->
        val parts = record.split(" ")
        val giver = parts.first()
        val receiver = parts.last()
        giftTracker.computeIfAbsent(giver) { mutableListOf() }.add(receiver)
        giftsGiven[giver] = giftsGiven.getOrDefault(giver, 0) + 1
    }

    users.forEach { user ->
        val receivedCount = giftTracker.values.flatten().count { giver -> giver == user }
        giftsReceived[user] = receivedCount
        scoreMap[user] = (giftsGiven[user] ?: 0) - (giftsReceived[user] ?: 0)
        totalGifts[user] = 0
    }

    for (i in users.indices) {
        val currentUser = users[i]
        var maxGiftCount = Int.MIN_VALUE
        for (j in users.indices) {
            val otherUser = users[j]
            if (i != j) {
                val giftsFromCurrent = giftTracker[currentUser]?.count { it == otherUser } ?: 0
                val giftsFromOther = giftTracker[otherUser]?.count { it == currentUser } ?: 0
                if (giftsFromCurrent > giftsFromOther) {
                    totalGifts[currentUser] = totalGifts.getOrDefault(currentUser, 0) + 1
                } else if (giftsFromCurrent == giftsFromOther) {
                    if (scoreMap[currentUser] ?: 0 > scoreMap[otherUser] ?: 0) {
                        totalGifts[currentUser] = totalGifts.getOrDefault(currentUser, 0) + 1
                    }
                }
            }
        }
        maxGiftCount = maxOf(maxGiftCount, totalGifts[currentUser] ?: 0)
        result = maxOf(maxGiftCount, result)
    }

    return result
}
