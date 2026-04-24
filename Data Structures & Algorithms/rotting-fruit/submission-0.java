class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c] == 2)
                    q.offer(new int[]{r, c});
                if(grid[r][c] == 1)
                     freshOranges++;
            }
        }

        int time = 0;
while (!q.isEmpty() && freshOranges > 0) {
    int size = q.size(); // Lock in the number of oranges for THIS minute
    for (int i = 0; i < size; i++) {
        int[] curr = q.poll();
        for (int[] dir : directions) {
            int nr = curr[0] + dir[0];
            int nc = curr[1] + dir[1];
            
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                grid[nr][nc] = 2;
                q.offer(new int[]{nr, nc});
                freshOranges--; // Track progress
            }
        }
    }
    time++; // Increment only after the entire level is processed
}

return freshOranges == 0 ? time : -1;
    }
}
