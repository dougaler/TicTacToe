
public class thegame {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] internalBoard = new String[ROW][COL];


    /**
     * Method to take the numbered result and turn it into a string labeling the result
     * @return returns the string version of the numbered result
     */
    public String controller(int newRow, int newCol, String player){
        boolean move = placeMove(newRow,newCol,player);
        String Result = " ";
        if(move) {
            if (isColWin(player) || isDiagnalWin(player) || isRowWin(player)) {
                Result = "Win!";
            } else if (isTie()) {
                Result = "Tie!";
            }
        }
        return Result;
    }
    private static boolean placeMove(int newRow, int newCol,String player){
        boolean check;
        internalBoard[newRow][newCol] = player;
        check = true;
        return check;
    }
    public static void clearBoard(){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                internalBoard[i][j] = " ";
            }
        }
    }

    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }

        return false;
    }
    private static boolean isColWin(String player)
    {
        // checks for a col win for specified player
        for(int col=0; col < COL; col++)
        {
            if(internalBoard[0][col].equals(player) &&
                    internalBoard[1][col].equals(player) &&
                    internalBoard[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(internalBoard[row][0].equals(player) &&
                    internalBoard[row][1].equals(player) &&
                    internalBoard[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isDiagnalWin(String player)
    {
        // checks for a diagonal win for the specified player

        if(internalBoard[0][0].equals(player) &&
                internalBoard[1][1].equals(player) &&
                internalBoard[2][2].equals(player) )
        {
            return true;
        }
        if(internalBoard[0][2].equals(player) &&
                internalBoard[1][1].equals(player) &&
                internalBoard[2][0].equals(player) )
        {
            return true;
        }
        return false;
    }

    // checks for a tie before internalBoard is filled.
    // check for the win first to be efficient
    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for(int row=0; row < ROW; row++)
        {
            if(internalBoard[row][0].equals("X") ||
                    internalBoard[row][1].equals("X") ||
                    internalBoard[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(internalBoard[row][0].equals("O") ||
                    internalBoard[row][1].equals("O") ||
                    internalBoard[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(internalBoard[0][col].equals("X") ||
                    internalBoard[1][col].equals("X") ||
                    internalBoard[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(internalBoard[0][col].equals("O") ||
                    internalBoard[1][col].equals("O") ||
                    internalBoard[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(internalBoard[0][0].equals("X") ||
                internalBoard[1][1].equals("X") ||
                internalBoard[2][2].equals("X") )
        {
            xFlag = true;
        }
        if(internalBoard[0][0].equals("O") ||
                internalBoard[1][1].equals("O") ||
                internalBoard[2][2].equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(internalBoard[0][2].equals("X") ||
                internalBoard[1][1].equals("X") ||
                internalBoard[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(internalBoard[0][2].equals("O") ||
                internalBoard[1][1].equals("O") ||
                internalBoard[2][0].equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }

        // Checked every vector so I know I have a tie
        return true;
    }
}
