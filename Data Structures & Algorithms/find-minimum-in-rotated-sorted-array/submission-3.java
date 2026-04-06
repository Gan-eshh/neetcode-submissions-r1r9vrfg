class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int res = nums[0];

        while(l<=h){
            int m = l + (h-l)/2;
            res = Math.min(res, nums[m]);
            if(nums[m] < nums[h])
                h = m;
            else
                l = m+1;
        }
        return nums[h];
    }
}
