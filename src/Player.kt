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

fun outputAA(player: Player) {
    var sAA = player.aa.toString()
    sAA = if (sAA.length == 2) sAA else "0" + sAA
    println(sAA)
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

fun updateOnRoundEnd(players: List<Player>) {
    for (player in players) {
        for (op in player.op) {
            player.opop += op.op
        }    
    }
}

fun main() {
    val player1 = Player("Shiv")
    val player2 = Player("Cat")
    val player3 = Player("Curie")
    val player4 = Player("Casper")
    val players = mutableListOf(player1, player2, player3, player4)
    updateOnGameWin(player1, player2)
    updateOnGameDraw(player3, player4)
    print("${player1.name}: ")
    outputAA(player1)
    print("${player2.name}: ")
    outputAA(player2)
    print("${player3.name}: ")
    outputAA(player3)
    print("${player4.name}: ")
    outputAA(player4)
    updateOnRoundEnd(players)
    println("${player1.op[0].name}, ${player1.opop[0].name}")
}