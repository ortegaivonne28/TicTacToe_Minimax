# Minimax for Tic Tact Toe game

Recursive method using a minimax type of algoritm to calculate each move the computer has to make in order to win or draw a tic tac toe game


## Details

Recursive method that loops through the matrix, if matrix[i][j] is an invalid player is means no one has played in that position so the method calculates the end result if each player plays in that position. The method is called until no more plays can be made or one of the two players have won. If no more plays can be mode that position will hold a value of 0, if the computer won, that position will hold a positive value, substracting the numbers of moves that had to be made for the computer to win. If the player is the one who wins, that position will hold a negative value, adding the number of moves that had to be made for the player to win. After all the matrix has been calculated, the method evaluates which value will give the best result for the computer.

##### Skills/languages/tools: Java, IntelliJ.




