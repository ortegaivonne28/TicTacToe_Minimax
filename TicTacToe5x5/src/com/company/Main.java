package com.company;

import java.util.Scanner;

public class Main {

    public static int mPlayer=10;

    public static void main(String[] args) {

        int[][] matrix = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        int[] move = new int[2];
//        char board[3][3] =
//        {
//            { 'x', 'o', 'x', 'o', 'x' },
//            { 'o', 'x', 'o', 'x', 'o' },
//            { 'x', '_', 'x', '_', '_' }
//            { 'o', '_', '_', '_', '_' }
//            { '_', 'o', '_', '_', 'x' }
//        };

        boolean aux=true;
       while(aux)
       {
           Scanner scanner = new Scanner(System.in);
           int x = scanner.nextInt();
           int y = scanner.nextInt();
           matrix[x][y] = 1;
           if(decidingWin(matrix,x,y,5,3,1)==1)
           {
               aux=false;
               System.out.println("PLAYER WINS");
           }

           move = findBestMove(matrix);
           matrix[move[0]][move[1]]=10;
           for(int i=0;i<5;i++)
           {
               for(int j=0;j<5;j++)
               {
                   System.out.print(matrix[i][j]+" ");
               }
               System.out.println();
           }
           if(!areThereMovesLeft(matrix))
               aux=false;
           if(decidingWin(matrix,x,y,5,3,10)==10)
           {
               aux=false;
               System.out.println("COMPUTER WINS");
           }

          // System.out.println(move[0] + " " + move[1]);
       }

    }

    public static int decidingWin(int[][] matrix,int x,int y,int n,int victory,int player)
    {
        int aux=0;
        boolean exit=true;
        for (int i=0;i<n;i++)
        {
            if(matrix[i][y]==player)
                aux++;
            else
                aux=0;
            if(aux==victory)
                return player;
        }
        if(aux==victory)
            return player;
        aux=0;
        for (int i=0;i<n;i++)
        {
            if (matrix[x][i] == player)
                aux++;
            else
                aux = 0;
            if (aux == victory)
                return player;
        }
        if(aux==victory)
            return player;
        if(x-(victory-1)>=0 && y+(victory-1)<=n-1)
        {
            aux=0;
            int i=x;
            int j=y;
            exit=true;
            while(exit)
            {
                if(matrix[i][j]==player)
                {
                    aux++;
                    i--;
                    j++;
                }
                else
                    exit=false;
                if(i<0 || j>n-1)
                    exit=false;
                //System.out.println("1");
            }
            if(aux==victory)
                return player;
        }
        if(x-(victory-1)>=0 && y-(victory-1)>=0)
        {
            aux=0;
            int i=x;
            int j=y;
            exit=true;
            while(exit)
            {
                if(matrix[i][j]==player)
                {
                    aux++;
                    i--;
                    j--;
                }
                else
                    exit=false;
                if(i<0 || j<0)
                    exit=false;
                //System.out.println("2");

            }
            if(aux==victory)
                return player;
        }
        if(x+(victory-1)<=n-1 && x-(victory-1)>=0)
        {
            aux=0;
            int i=x;
            int j=y;
            exit=true;
            while(exit)
            {
                if(matrix[i][j]==player)
                {
                    aux++;
                    i++;
                    j--;
                }
                else
                    exit=false;
                if(i>n-1 || j<0)
                    exit=false;
                //System.out.println("3");

            }
            if(aux==victory)
                return player;
        }
        if(x+(victory-1)<=n-1 && y+(victory-1)<=n-1)
        {
            aux=0;
            int i=x;
            int j=y;
            exit=true;
            while(exit)
            {
                if(matrix[i][j]==player)
                {
                    aux++;
                    i++;
                    j++;
                }
                else
                    exit=false;
                if(i>n-1 || j>n-1)
                    exit=false;
                //System.out.println("4");

            }
            if(aux==victory)
                return player;

        }
        return -1;


    }


   // Check if there's a winner and returns the value depending on who the winner is
    public static int isThereAWin(int[][] matrix)
    {

        int aux=0;
        int player;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                //if(matrix[i][j]!=0)
                //{
                    player = matrix[i][j];
                    if(player!=0)
                    {
                        aux = decidingWin(matrix, i, j, 5, 3, player);
                        if (aux != -1)
                        {
                           // System.out.println(aux);
                            if (aux == 10)
                                return 10;
                            else
                                return -10;
                        }
                    }
                //}
            }
        }


       return 0;
    }

    public static int miniMax(int[][] matrix,int depth, int player)
    {
        int score = isThereAWin(matrix);
        int bestC = -1000;
        int bestP = 1000;
        int aux=0;
        //If computer has won
        //score - depth
        //depth-score
        if (score == 10) {
            return score-depth;
            //return score;
        }

        //If user has won
        if (score == -10) //depth-10
        {
            return depth-score;
            //return score;
            //return depth - score;
        }

        if(depth>3)
            return score;

        //If there are no moves left means no one wins
        if (!areThereMovesLeft(matrix))
            return 0;


        if(score==0)
        {
            if (player == 1) {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if (matrix[i][j] == 0)
                        {
                            matrix[i][j] = player;
                            aux = miniMax(matrix, depth + 1, 10);

                            if (aux < bestP)
                            {
//                                System.out.println("PLayer 1: "+aux);
//                                System.out.println("Movimientos: X="+i+" Y="+j);
//                                System.out.println();
//                                System.out.println(aux);
                                bestP = aux;
                            }
                            matrix[i][j] = 0;
                        }
                    }
                }
                return bestP;
            } else {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if (matrix[i][j] == 0)
                        {
                            matrix[i][j] = player;
                            aux = miniMax(matrix, depth + 1, 1);

                            if (aux > bestC) {
//                                System.out.println("PLayer 10: "+aux);
//                                System.out.println("Movimientos: X="+i+" Y="+j);
//                                System.out.println();
//
//                                System.out.println(aux);
                                bestC = aux;
                            }
                            matrix[i][j] = 0;
                        }
                    }
                }
                return bestC;
            }

        }
        return aux;
    }

    public static boolean areThereMovesLeft(int[][] matrix)
    {

        for (int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(matrix[i][j]==0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void changePlayer()
    {
        if(mPlayer==1)
            mPlayer=10;
        else
            mPlayer=1;
    }

    public static int[] findBestMove(int matrix[][])
    {
        int bestVal = -1001;
        int[] bestMove = new int[2];
        int moveVal;
        bestMove[0] = 0;
        bestMove[1] = 0;

        for (int i = 0; i<5; i++)
        {
            for (int j = 0; j<5; j++)
            {
                // Check if cell is empty

                if (matrix[i][j]==0)
                {

                    // Make the move
                    matrix[i][j] = mPlayer;

                    changePlayer();
                    moveVal = miniMax(matrix, 0,mPlayer );
                    //System.out.println("MOVEVAL: "+moveVal+" X= "+i+" Y= "+j);
                    // System.out.println(matrix[i][j]+" "+moveVal);
                    // Undo the move
                    matrix[i][j] = 0;
                    changePlayer();

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/

                    if (moveVal > bestVal)
                    {
                        bestMove[0]= i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }
}
