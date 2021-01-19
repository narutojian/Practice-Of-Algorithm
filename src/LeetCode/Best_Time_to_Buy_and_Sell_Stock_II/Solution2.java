package LeetCode.Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution2 {
    /**
     * dp
     * dp[i][0]: 表示第i天不持股所得最大利润
     * dp[i][1]: 表示第i天持股所得最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] -= prices[0];
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }

        return dp[days-1][0];
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

//        int[] prices = {7,1,5,3,6,4};

//        int[] prices = {1,2,3,4,5};

//        int[] prices = {7,6,4,3,1};

        int[] prices = {1,2};

        System.out.println(solution2.maxProfit(prices));
    }
}


