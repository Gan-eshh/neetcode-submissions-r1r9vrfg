class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, h = m*n-1;

        while(l<=h){
            int mid = l+(h-l)/2;

            int r = mid/m;
            int c = mid%m;

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                h = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
}
