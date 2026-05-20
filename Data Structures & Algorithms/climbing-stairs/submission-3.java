// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         return fuc(n, dp);
//     }
//     int fuc(int n, int[] dp){
//         if(n==0)    return 1;
//         if(n==1)    return 1;

//         if(dp[n] != 0)    return dp[n];
//         dp[n] = fuc(n-1, dp)+fuc(n-2, dp);

//         return dp[n];
//     }
// }

class Solution {
    public int climbStairs(int n) {
        if(n==1)    return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
