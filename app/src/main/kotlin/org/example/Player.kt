package com.themegatree

class Player(
    var name: String,
    var w: Int = 0,
    var d: Int = 0,
    var l: Int = 0,
    var aa: Int = 0,
    var bbb: Int = 0,
    var ccc: Int = 0,
    var ddd: Int = 0,
    var op: List<Player> = mutableListOf(),
    var opop: List<Player> = mutableListOf()) {

    fun updateW() {
        w += 1
    }

    fun updateD() {
        d += 1
    }

    fun updateL() {
        l += 1
    }

    fun outputWLD() : String {
        return "$w/$l/$d"
    }

    fun updateAA(toAdd: Int = 1) {
        aa += toAdd
    }

}

fun outputAA(player: Player): String {
    var sAA = player.aa.toString()
    sAA = if (sAA.length == 2) sAA else "0$sAA"
    return sAA
}

fun outputXXX(iXXX: Int) : String {
    var sXXX = iXXX.toString()
    sXXX = when(sXXX.length) {
        1 -> "00$sXXX"
        2 -> "0$sXXX"
        else -> sXXX
    }
    return sXXX
}

fun outputBBB(player: Player): String {
    return outputXXX(player.bbb)
}

fun outputCCC(player: Player): String {
    return outputXXX(player.ccc)
}

fun outputDDD(player: Player): String {
    return outputXXX(player.ddd)
}

fun outputAABBBCCCDDD(player: Player) : String {
    val tiebreaker = outputAA(player) + outputBBB(player) + outputCCC(player) + outputDDD(player)
    return tiebreaker
}

fun createPairs(players: List<Player>): List<List<Player>> {
    val pairs = players.chunked(2)
    return pairs
}

fun updateOnGameEnd(playerOne: Player, playerTwo: Player) {
    playerOne.op += playerTwo
    playerTwo.op += playerOne
}

fun updateOnGameWin(winner: Player, loser: Player) {
    updateOnGameEnd(winner, loser)
    winner.updateW()
    loser.updateL()
    winner.updateAA(3)
    loser.ddd += (loser.l + loser.d + loser.w)*(loser.l + loser.d + loser.w)
}

fun updateOnGameDraw(playerOne: Player, playerTwo: Player) {
    updateOnGameEnd(playerOne, playerTwo)
    playerOne.updateD()
    playerTwo.updateD()
    playerOne.updateAA()
    playerTwo.updateAA()
}

fun calculateAvgWinRate(opponents: List<Player>): Int {
    var winRate = 0
    for (opponent in opponents) {
        winRate += 1000 * opponent.w/(opponent.w + opponent.d + opponent.l)
    }
    val avgWinRate = winRate/opponents.size
    return if (avgWinRate == 1000) 999 else avgWinRate
}

fun updateOnRoundEnd(players: List<Player>) {
    for (player in players) {
        for (op in player.op) {
            player.opop += op.op
            player.opop = player.opop.distinct()
        }
        player.bbb += calculateAvgWinRate(player.op)
        player.ccc += calculateAvgWinRate(player.opop)
    }
}

fun main() {
    val player1 = Player("Shiv")
    val player2 = Player("Casper")
    val player3 = Player("Cat")
    val player4 = Player("Curie")
    val players = mutableListOf(player1, player2, player3, player4)
    val pairs = createPairs(players)
    updateOnGameWin(pairs[0][0], pairs[0][1])
    updateOnGameWin(pairs[1][0], pairs[1][1])
    updateOnRoundEnd(players)
    updateOnGameWin(player1, player4)
    updateOnGameDraw(player2, player3)
    updateOnRoundEnd(players)
    val p1Tiebreaker = outputAABBBCCCDDD(player1)
    val p2Tiebreaker = outputAABBBCCCDDD(player2)
    val p3Tiebreaker = outputAABBBCCCDDD(player3)
    val p4Tiebreaker = outputAABBBCCCDDD(player4)
    println("${player1.name}:   ${player1.aa} " + player1.outputWLD() + " $p1Tiebreaker")
    println("${player3.name}:    ${player3.aa} " + player3.outputWLD() + " $p3Tiebreaker")
    println("${player2.name}: ${player2.aa} " + player2.outputWLD() + " $p2Tiebreaker")
    println("${player4.name}:  ${player4.aa} " + player4.outputWLD() + " $p4Tiebreaker")
}
