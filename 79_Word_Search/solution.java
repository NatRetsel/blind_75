class Solution {
    private boolean dfs(char[][] board, String word, int r, int c, int currIdx) {
        if (currIdx == word.length()) return true;
        if (r < 0 || r == board.length || c < 0 || c == board[0].length ||
            board[r][c] != word.charAt(currIdx)) return false;
        boolean found = false;
        if (board[r][c] == word.charAt(currIdx)) {
            board[r][c] += 100;
            found = dfs(board, word, r-1, c, currIdx+1) || 
                    dfs(board, word, r+1, c, currIdx+1) ||
                    dfs(board, word, r, c-1, currIdx+1) ||
                    dfs(board, word, r, c+1, currIdx+1); 
            board[r][c] -= 100;
        }
        
        return found;
        
    }
    public boolean exist(char[][] board, String word) {
        /*
            Input: 2D char array board, String word
            Output: Boolean true if word exist in board, else false

            Word can be constructed only sequentially adjacent (horizontal / vertically neighboring)

            Strategy
            1.) DFS and each dfs calls has it's own seen set to prevent duplicates
                - Terminating conditions
                    - board[r][c] not equals to character at currIdx of word OR
                    - r < 0 || r == row OR
                    - c < 0 || c == col 
                    - return false
                - if currIdx == word.length() return true
                - add (r,c) to seen. We can modify the cell and revert at the end of search instead of 
                using a convoluted hashset
                - dfs top
                - dfs down
                - dfs left
                - dfs right
                - return top || down || left || right
        */
        for (int i=0; i< board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }
}