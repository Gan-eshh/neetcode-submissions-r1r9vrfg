class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return fuc(n, dp);
    }
    int fuc(int n, int[] dp){
        if(n==0)    return 1;
        if(n==1)    return 1;

        if(dp[n] != 0)    return dp[n];
        dp[n] = fuc(n-1, dp)+fuc(n-2, dp);

        return dp[n];
    }
}
