package LeetCode.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution2 {

    /**
     * dp
     * dp[i][0] : 到第i天 持有一支股票的最大利益
     * dp[i][1] : 到第i天 卖出股票并处于coolDown时期的最大利益
     * dp[i][2] : 到第i天 未处于coolDown时期且未持有股票的最大利益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }

        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
    }
}
