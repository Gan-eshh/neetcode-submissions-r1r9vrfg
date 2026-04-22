class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        if(grid == null || n==0||m==0)
            return 0;
        
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r >= grid.length || c>=grid[0].length || grid[r][c] == '0')
            return;
        
        grid[r][c] ='0';
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }
}