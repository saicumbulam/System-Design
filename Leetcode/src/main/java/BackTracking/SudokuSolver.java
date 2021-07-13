package BackTracking;

//o(9!)^9 | o(81)
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }


    private boolean solve(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                char c = board[i][j];

                if (c == '.')
                {
                    for(char k = '1'; k <= '9'; k++)
                    {
                        if(valid(board, i, j, (char) k))
                        {
                            board[i][j] = (char) k;
                            if (solve(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = '.';
                            }

                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean valid(char[][] board, int r, int c, char ch)
    {
        for(int k = 0; k < 9; k++)
        {
            if (board[k][c] != '.' && board[k][c] == ch)
            {
                return false;
            }

            if (board[r][k] != '.' && board[r][k] == ch)
            {
                return false;
            }

            if (board[3 * (r/3) + k/3][3 * (c/3) + k%3] != '.' &&
                    board[3 * (r/3) + k/3][3 * (c/3) + k%3] == ch)
            {
                return false;
            }
        }
        return true;
    }
}
