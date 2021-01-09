package LeetCode.Best_Time_to_Buy_and_Sell_Stock;

public class Solution4 {

    /**
     * 动态规划 空间优化
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int dp = 0;
        int days = prices.length;
        for (int i = days-2; i > -1; i--) {
            dp = Math.max(0,dp+prices[i+1]-prices[i]);
            profit = Math.max(profit,dp);
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

//        int[] prices = {7,1,5,3,6,4};

//        int[] prices = {7,6,4,3,1};

        int[] prices = {1,2};

        System.out.println(solution4.maxProfit(prices));
    }
}
