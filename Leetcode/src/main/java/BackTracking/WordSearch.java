package BackTracking;

// O(N⋅3^L) | O(L)
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if (word.charAt(0) == board[i][j])
                {
                    if (dfs(board, word, i, j, 0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, String word, int r, int c, int index)
    {
        if (index >= word.length()) return true;

        if (r < 0 || c < 0 || c >= board[0].length
                || r >= board.length || board[r][c] == ' ' ||
                board[r][c] != word.charAt(index))
        {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = ' ';

        boolean found = dfs(board, word, r+1, c, index+1) ||
                dfs(board, word, r-1, c, index+1) ||
                dfs(board, word, r, c+1,index+1) ||
                dfs(board, word, r, c-1, index+1);

        board[r][c] = temp;
        return found;
    }
}
