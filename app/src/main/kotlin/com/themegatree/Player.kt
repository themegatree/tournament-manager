package com.themegatree

class Player (var inputName: String) {

    val name: String
    var w: Int
    var d: Int
    var l: Int
    var aa: Int
    var bbb: Int
    var ccc: Int
    var ddd: Int
    var op: List<Player>
    var opop: List<Player>

    init {
        name = inputName
        w = 0
        d = 0
        l = 0
        aa = 0
        bbb = 0
        ccc = 0
        ddd = 0 
        op =  mutableListOf()
        opop =  mutableListOf()
    }

    fun outputName() : String {return this.name}
    fun outputW() : Int {return this.w}
    fun outputD() : Int {return this.d}
    fun outputL() : Int {return this.l}
    fun outputAA() : Int {return this.aa}
    fun outputBBB() : Int {return this.bbb}
    fun outputCCC() : Int {return this.ccc}
    fun outputDDD() : Int {return this.ddd}

    fun outputWLD() : String {return "$w/$l/$d"}

    fun updateW(num: Int) {this.w += num}
    fun updateD(num: Int) {this.d += num}
    fun updateL(num: Int) {this.l += num}
    fun updateAA(num: Int) {this.aa += num}
    fun updateBBB(num: Int) {this.bbb = num}
    fun updateCCC(num: Int) {this.ccc = num}
    fun updateDDD(num: Int) {this.ddd += num}
    
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

fun outputBBB(player: Player): String {return outputXXX(player.bbb)}
fun outputCCC(player: Player): String {return outputXXX(player.ccc)}
fun outputDDD(player: Player): String {return outputXXX(player.ddd)}

fun outputAABBBCCCDDD(player: Player) : String {
    val tiebreaker = outputAA(player) + outputBBB(player) + outputCCC(player) + outputDDD(player)
    return tiebreaker
}

fun Player.outputTiebreaker(): Long {
    val sTiebreaker = outputAABBBCCCDDD(this)
    val lTiebreaker = sTiebreaker.toLong()
    return lTiebreaker
}

fun createPairs(players: List<Player>): List<List<Player>> {
    val pairs = players.chunked(2)
    return pairs
}

fun List<Player>.orderPlayers(): List<Player> {
    val orderedPlayers = sortedByDescending { it.outputTiebreaker() }
    return orderedPlayers
}

fun bye(size: Int, player: Player, byes: MutableList<Player>) {
    if (size % 2 != 0) {
        byes.add(player)
        player.updateW(1)
        player.updateAA(3)
    } 
}

fun updateOnGameEnd(playerOne: Player, playerTwo: Player) {
    playerOne.op += playerTwo
    playerTwo.op += playerOne
}

fun updateOnGameWin(winner: Player, loser: Player) {
    updateOnGameEnd(winner, loser)
    winner.updateW(1)
    loser.updateL(1)
    winner.updateAA(3)
    loser.ddd += (loser.l + loser.d + loser.w)*(loser.l + loser.d + loser.w)
}

fun updateOnGameDraw(playerOne: Player, playerTwo: Player) {
    updateOnGameEnd(playerOne, playerTwo)
    playerOne.updateD(1)
    playerTwo.updateD(1)
    playerOne.updateAA(1)
    playerTwo.updateAA(1)
}

fun calculateAvgWinRate(opponents: List<Player>): Int {
    var winRate = 0
    for (opponent in opponents) {
        try {
            winRate += 1000 * opponent.w/(opponent.w + opponent.d + opponent.l)
        } catch (e: ArithmeticException) {
            println("${e.message}")
        }
    }
    var avgWinRate = 0
    try {
        avgWinRate = winRate/opponents.size
    } catch (e: ArithmeticException) {
        println("No opponents. Error: ${e.message}")
    }
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
    val player5 = Player("Lulu")
    val players = mutableListOf(player1, player2, player3, player4, player5)
    var pairs = createPairs(players)
    var byes: MutableList<Player> = mutableListOf()
    bye(players.size, pairs.last().get(0), byes)
    updateOnGameWin(pairs[0][0], pairs[0][1])
    updateOnGameWin(pairs[1][0], pairs[1][1])
    updateOnRoundEnd(players)
    pairs = createPairs(players.orderPlayers())
    bye(players.size, pairs.last().get(0), byes)
    updateOnGameDraw(pairs[0][0], pairs[0][1])
    updateOnGameWin(pairs[1][0], pairs[1][1])
    updateOnRoundEnd(players)
    val p1Tiebreaker = outputAABBBCCCDDD(player1)
    val p2Tiebreaker = outputAABBBCCCDDD(player2)
    val p3Tiebreaker = outputAABBBCCCDDD(player3)
    val p4Tiebreaker = outputAABBBCCCDDD(player4)
    println("${player3.outputName()}:    ${player3.aa} " + player3.outputWLD() + " $p3Tiebreaker")
    println("${player1.outputName()}:   ${player1.aa} " + player1.outputWLD() + " $p1Tiebreaker")
    println("${player4.outputName()}:  ${player4.aa} " + player4.outputWLD() + " $p4Tiebreaker")
    println("${player2.outputName()}: ${player2.aa} " + player2.outputWLD() + " $p2Tiebreaker")

    val testplayer = Player("Lulu")
    testplayer.updateW(1)
    println(testplayer.outputW())

}
