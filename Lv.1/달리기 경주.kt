package Lv.`1`

fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    val rankList = players.copyOf()
    val playerMap = hashMapOf<String, Int>()

    players.forEachIndexed { index, player ->
        playerMap[player] = index
    }

    callings.forEach { calledPlayer ->
        playerMap[calledPlayer]?.let {
            if (it > 0) {
                val nextPlayer = rankList[it - 1]
                rankList[it] = nextPlayer
                rankList[it - 1] = calledPlayer

                playerMap[calledPlayer] = it - 1
                playerMap[nextPlayer] = it
            }
        }
    }

    return rankList
}
