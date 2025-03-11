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
    var opop: List<Player> = mutableListOf())

fun outputAA(player: Player): String {
    var sAA = player.aa.toString()
    sAA = if (sAA.length == 2) sAA else "0" + sAA
    return sAA
}

fun outputBBB(player: Player): String {
    var sBBB = player.bbb.toString()
    sBBB = when(sBBB.length) {
        1 -> "00" + sBBB
        2 -> "0" + sBBB
        else -> sBBB
    }
    return sBBB
}

fun outputCCC(player: Player): String {
    var sCCC = player.ccc.toString()
    sCCC = when(sCCC.length) {
        1 -> "00" + sCCC
        2 -> "0" + sCCC
        else -> sCCC
    }
    return sCCC
}

fun outputDD(player: Player): String {
    var sDDD = player.ddd.toString()
    sDDD = when(sDDD.length) {
        1 -> "00" + sDDD
        2 -> "0" + sDDD
        else -> sDDD
    }
    return sDDD
}

fun outputAABBBCCCDDD(player: Player) : String {
    var tiebreaker = outputAA(player) + outputBBB(player) + outputCCC(player) + outputDD(player)
    return tiebreaker
}

fun updateOnGameEnd(playerOne: Player, playerTwo: Player) {
    playerOne.op += playerTwo
    playerTwo.op += playerOne
}

fun updateOnGameWin(winner: Player, loser: Player) {
    updateOnGameEnd(winner, loser)
    winner.w += 1;
    loser.l += 1;
    winner.aa += 3;
    loser.ddd += (loser.l + loser.d + loser.w)*(loser.l + loser.d + loser.w);
}

fun updateOnGameDraw(playerOne: Player, playerTwo: Player) {
    updateOnGameEnd(playerOne, playerTwo)
    playerOne.d += 1
    playerTwo.d += 1
    playerOne.aa += 1
    playerTwo.aa += 1
}

fun calculateAvgWinRate(opponents: List<Player>): Int {
    var count: Int = 0
    var winRate: Int = 0
    var avgWinRate: Int = 0
    for (opponent in opponents) {
        count += 1
        winRate += 1000 * opponent.w/(opponent.w + opponent.d + opponent.l)
        avgWinRate = winRate/count
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
    val players = mutableListOf(player1, player2, player3, player4)
    updateOnGameWin(player1, player2)
    updateOnGameWin(player3, player4)
    updateOnRoundEnd(players)
    updateOnGameWin(player1, player4)
    updateOnGameDraw(player2, player3)
    updateOnRoundEnd(players)
    var p1Tiebreaker = outputAABBBCCCDDD(player1)
    var p2Tiebreaker = outputAABBBCCCDDD(player2)
    var p3Tiebreaker = outputAABBBCCCDDD(player3)
    var p4Tiebreaker = outputAABBBCCCDDD(player4)
    println("${player1.name}: ${p1Tiebreaker}")
    println("${player3.name}: ${p3Tiebreaker}")
    println("${player2.name}: ${p2Tiebreaker}")
    println("${player4.name}: ${p4Tiebreaker}")
}