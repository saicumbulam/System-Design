package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//O(M(4⋅3^L−1)) | o(N)
public class WordSearchII {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }

    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;

            for (Character letter : word.toCharArray()) {
                if (curr.children.containsKey(letter)) {
                    curr = curr.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    curr.children.put(letter, newNode);
                    curr = newNode;
                }
            }
            curr.word = word;  // store words in Trie
        }

        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return this._result;
    }

    private void backtracking(int row, int col, TrieNode root)
    {
        if (row < 0 || row >= this._board.length || col < 0
                || col >= this._board[0].length ||
                !root.children.containsKey(this._board[row][col]))
        {
            return;
        }


        Character letter = this._board[row][col];
        TrieNode currNode = root.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        backtracking(row+1, col, currNode);
        backtracking(row-1, col, currNode);
        backtracking(row, col+1, currNode);
        backtracking(row, col-1, currNode);


        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;
    }
}
