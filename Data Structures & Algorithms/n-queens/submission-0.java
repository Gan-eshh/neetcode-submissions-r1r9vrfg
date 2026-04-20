class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(board[i], '.');
        
        solve(board, 0, res);

        return res;
    }

    void solve(char[][] board, int c, List<List<String>> res){
        if(c == board.length){
            res.add(construct(board));
            return;
        }

        for(int r=0;r<board.length;r++){
            if(isSafe(board, r, c)){
                board[r][c] = 'Q';
                solve(board, c+1, res);
                board[r][c] = '.';
            }
        }
    }

    List<String> construct(char[][] board){
        List<String> tmp = new ArrayList<>();
        for(char[] ch : board)
            tmp.add(new String(ch));
        return tmp;
    }

    boolean isSafe(char[][] board, int r, int c){
        int dupr = r;
        int dupc = c;
        while(r >= 0 && c>=0){
            if(board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        r = dupr;
        c = dupc;

        while(c>=0){
            if(board[r][c] == 'Q')
                return false;
            c--;
        }

        r = dupr;
        c = dupc;
        while(c>=0 && r<board.length){
            if(board[r][c] == 'Q')
                return false;
            c--;
            r++;
        }
        return true;
    }
}
