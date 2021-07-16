package HashTable;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i< board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    if(!set.add(board[i][j] + " in row " + String.valueOf(i)) ||
                            !set.add(board[i][j] + " in col " + String.valueOf(j)) ||
                            !set.add(board[i][j] + " in row-3 " + String.valueOf(i/3)
                                    + " in col-3 " + String.valueOf(j/3)))
                    {
                        return false;
                    }

                }
            }
        }

        return true;
    }
}
