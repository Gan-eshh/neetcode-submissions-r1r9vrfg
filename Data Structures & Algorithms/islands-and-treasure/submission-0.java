class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;

        int min = 2147483647;
        System.out.println(min);
        
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0)
                    q.offer(new int[] {i, j});
            }
        }

        while(!q.isEmpty()){
            int[] gate = q.poll();
            int r = gate[0];
            int c = gate[1];

            for(int[] dir : directions){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr >=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == min){
                    grid[nr][nc] = grid[r][c]+1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
