package Design;

public class TicTacToe {
    int n = 0;
    int diag = 0;
    int xdiag = 0;
    int[] rowCounter;
    int[] colCounter;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.rowCounter = new int[n];
        this.colCounter = new int[n];

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;

        this.rowCounter[row] += move;
        this.colCounter[col] += move;

        if (row + col == n-1)
        {
            this.diag += move;
        }

        if (row == col)
        {
            this.xdiag += move;
        }


        if (Math.abs(this.rowCounter[row]) == n ||
                Math.abs(this.colCounter[col]) == n ||
                Math.abs(this.xdiag) == n ||
                Math.abs(this.diag) == n)
        {
            return player;
        }

        return 0;
    }
}
