Tournament Manager

Requirements:

We need to create a pairing algorithm that pairs based on ELO. The aim is to:
 
Pairs must not have played against eachother before (unless absolutely necessary)
The system should try to pair people with the similar ELOs
There should be a bye assigned to a player if the total number is odd
If an odd number of players are in the tournament then a bye should be assigned

The bye should function as follows:
 
The bye should be assigned to a player who has not received a bye
The bye should be assigned to a player that has a low ELO (maybe the lowest to be determined)
The player with the bye gets a win for the round

ELO will be designed to work like this:
 
All players start at 0 ELO
Your ELO is defined as AABBBCCCDDD
AA is your points with 3 for a win 1 for a draw and 0 for a win
BBB is the win percentage of all of your opponents (in 3 digits)
CCC is the win percentage of all your opponents' opponents (in 3 digits)
DDD is the square of the rounds that you have lost in
If BBB or CCC are 100% then assign a value 999

Extension:
  
Allow players to drop out of the competition between rounds
If two players have the same ELO and they have played, place the player that won above
