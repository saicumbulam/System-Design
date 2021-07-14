package Matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[] neighbour = {0,1,-1};

        for(int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                int liveNeighbour = 0;

                for (int i = 0; i < neighbour.length; i++)
                {
                    for (int j = 0; j < neighbour.length; j++)
                    {
                        if (!(neighbour[i] == 0 && neighbour[j] == 0))
                        {
                            int newRow = row + neighbour[i];
                            int newCol = col + neighbour[j];

                            if (newRow >= 0 && newRow < board.length &&
                                    newCol >= 0 && newCol < board[0].length &&
                                    Math.abs(board[newRow][newCol]) == 1)
                            {
                                liveNeighbour++;
                            }
                        }
                    }
                }

                if (board[row][col] == 1 && (liveNeighbour < 2  || liveNeighbour > 3))
                {
                    board[row][col] = -1;
                }
                else if (board[row][col] == 0  && liveNeighbour == 3)
                {
                    board[row][col] = 2;
                }

            }

        }


        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (board[row][col] > 0)
                {
                    board[row][col] = 1;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }

    }
}
