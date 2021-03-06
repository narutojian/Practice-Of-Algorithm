package LeetCode.Perfect_Squares;

import java.util.Arrays;

public class Solution4 {

    public int numSquares(int n) {
        int[] dp = new int[n+1]; // dp[i] : 表示 i 分为所有平方数最少需要几步
        Arrays.fill(dp,-1);
        return minNum(n,dp);
    }

    private int minNum(int n,int[] dp) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = Integer.MAX_VALUE;
        for (int i = (int) Math.floor(Math.sqrt(n)); i > 0; i--) {
            int cur = i*i;
            dp[n] = Math.min(dp[n],minNum(n-cur,dp)+1);
        }
        return dp[n];
    }
}
