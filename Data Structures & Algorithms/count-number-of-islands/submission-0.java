class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        if(grid == null || n==0||m==0)  return islands;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for(int[] dir : directions){
                int nr = row+dir[0], nc = col+dir[1];
                if(nr>=0 && nc>=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
