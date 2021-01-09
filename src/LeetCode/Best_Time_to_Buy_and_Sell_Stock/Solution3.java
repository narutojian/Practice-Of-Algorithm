package LeetCode.Best_Time_to_Buy_and_Sell_Stock;

public class Solution3 {

    /**
     * 动态规划
     * dp[i]:表示在第i天买股票能赚到的最大利润
     * dp[i+1]与dp[i]的关系即为：
     * 在第i天买股票，只要比较prices[i]与prices[i+1]，因为在计算dp[i]与dp[i+1]时，
     * 他们的股票最大价格都是一样的。那么dp[i]与dp[i+1]的区别就在于prices[i]于prices[i+1]
     * 递推公式:
     * dp[i] = dp[i+1]+prices[i+1]-prices[i]
     *
     * 另外需要一个变量来记录最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int profit = 0;
        int[] dp = new int[days];
        // 初始化
        for (int i = 0; i < days; i++) {
            dp[i] = 0;
        }
        for (int i = days-2; i > -1; i--) {
            dp[i] = Math.max(0,dp[i+1]+prices[i+1]-prices[i]);
            profit = Math.max(profit,dp[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

//        int[] prices = {7,1,5,3,6,4};

//        int[] prices = {7,6,4,3,1};

        int[] prices = {1,2};

        System.out.println(solution3.maxProfit(prices));
    }
}
