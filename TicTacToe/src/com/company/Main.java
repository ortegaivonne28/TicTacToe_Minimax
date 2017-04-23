package com.company;

public class Main {
    private static final int MIN_VALUE = -100000;

    //Computer 10
    //Player -10

    //-- VERIFY IF THERE'S A WINNER --//
    //-- RETURN 10 IF COMPUTER WINS --//
    //-- RETURNS -10 IF PLAYER WINS --//

    public static int isThereAWin(int[][] matrix)
    {
        int i;
        for(i=0;i<3;i++)
        {
            if((matrix[i][0]==10&&matrix[i][1]==10&&matrix[i][2]==10)||(matrix[i][0]==-10&&matrix[i][1]==-10&&matrix[i][2]==-10))
            {
                if(matrix[i][0]==10)
                    return 10;
                else
                    return -10;
            }
        }
        for(i=0;i<3;i++)
        {
            if((matrix[0][i]==10&&matrix[1][i]==10&&matrix[2][i]==10)||(matrix[0][i]==-10&&matrix[1][i]==-10&&matrix[2][i]==-10))
            {
                if(matrix[0][i]==10)
                    return 10;
                else
                    return -10;
            }
        }
        if((matrix[0][0]==10&&matrix[1][1]==10&&matrix[2][2]==10)||(matrix[0][0]==-10&&matrix[1][1]==-10&&matrix[2][2]==-10))
        {
            if(matrix[0][0]==10)
                return 10;
            else
                return -10;

        }
        if((matrix[0][2]==10&&matrix[1][1]==10&&matrix[2][0]==10)||(matrix[0][2]==10&&matrix[1][1]==10&&matrix[2][0]==10))
        {
            if(matrix[1][1]==10)
                return 10;
            else
                return -10;
        }
        return 0;

    }


    //-- VERIFY IS THERE ARE STILL MOVES TO MAKE --//
    //-- IF THERE ARE STILL MOVES AVAILABLES RETURNS 1 --//
    //-- IF NO MORE MOVES RETURNS 0 --//
    public static int isThereATie(int[][] matrix)
    {
        for (int i = 0; i <3 ; i++)
        {
            for (int j = 0; j < 3; j++) {
                if(matrix[i][j]==0)
                    return 1;
            }
        }


        return 0;
    }


    public static int miniMax(int[][] matrix, int player, int depth)
    {
        int bestMove=MIN_VALUE;
        int score;
        score=isThereAWin(matrix);
        if(score==-10)
            return -10;
        if(score==10)
            return 10;
        if(isThereATie(matrix)==1)
            return 0;

        //IF PLAYER IS COMPUTER
        if(player==10)
        {
            int aux;
            for (int i = 0; i < 3 ; i++)
            {
                for (int j = 0; j < 3 ; j++)
                {
                    if()
                }
            }
        }
        //IF PLAYER IS 'PLAYER'
        else
        {

        }




        return 0;
    }

    public static int findBestMove(int[][] matrix, int player)
    {
        int bestMove=MIN_VALUE;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(matrix[i][j]==0)
                {

                }
            }
        }


        return 0;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
