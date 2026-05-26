class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp1 = new int[n-1];
        Arrays.fill(dp1, -1);
        int fi = maxMoneyRob(Arrays.copyOfRange(nums, 0, n - 1), dp1, n - 2);
        int[] dp2 = new int[n-1];
        Arrays.fill(dp2, -1);
        int se = maxMoneyRob(Arrays.copyOfRange(nums, 1, n), dp2, n - 2);
        return Math.max(fi, se);
    }

    int maxMoneyRob(int[] nums, int[] dp, int ind) {
        if (ind == 0)
            return nums[0];
        if (ind == 1)
            return Math.max(nums[0], nums[1]);
        if (ind < 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        dp[ind] =
            Math.max(nums[ind] + maxMoneyRob(nums, dp, ind - 2), maxMoneyRob(nums, dp, ind - 1));

        return dp[ind];
    }
}