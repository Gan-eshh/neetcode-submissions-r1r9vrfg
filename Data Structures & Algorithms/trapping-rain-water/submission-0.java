class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int l = 0;
        int r = n-1;
        int lMax = 0;
        int rMax = 0;

        while(l < r){
            if(height[l] <= height[r]){
                if(lMax > height[l])
                    maxArea += lMax - height[l];
                else
                    lMax = height[l];
                l++;
            }
            else{
                if(rMax > height[r])
                    maxArea += rMax - height[r];
                else
                    rMax = height[r];
                r--;
            }
        }
        return maxArea;
    }
}
