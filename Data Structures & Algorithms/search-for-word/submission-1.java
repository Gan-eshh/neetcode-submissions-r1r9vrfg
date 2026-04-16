class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(dfsAndBacktrack(board, r, c, word, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfsAndBacktrack(char[][] board, int r, int c, String word, int wordInd){
        if(wordInd == word.length())
            return true;
        
        int rows = board.length;
        int cols = board[0].length;
        
        if(r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] == ' ' || board[r][c] != word.charAt(wordInd))
            return false;
        
        char ch = board[r][c];
        board[r][c] = ' ';

        if(dfsAndBacktrack(board, r-1, c, word, wordInd+1) ||
            dfsAndBacktrack(board, r, c-1, word, wordInd+1) ||
            dfsAndBacktrack(board, r, c+1, word, wordInd+1) ||
            dfsAndBacktrack(board, r+1, c, word, wordInd+1))
            return true;
        
        board[r][c] = ch;

        return false;
    }
}
