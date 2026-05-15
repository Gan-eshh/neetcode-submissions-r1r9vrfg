class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxWater = 0;

        int l = 0;
        int r = n-1;

        while(l < r){
            int curWater = Math.min(heights[l], heights[r]);
            maxWater =  Math.max(maxWater, curWater*(r-l));

            if(heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return maxWater;
    }
}
