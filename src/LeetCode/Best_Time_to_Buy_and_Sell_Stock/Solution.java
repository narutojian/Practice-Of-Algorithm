package LeetCode.Best_Time_to_Buy_and_Sell_Stock;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class Solution {

    /**
     * 暴力枚举
     * 时间复杂度 O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int days = prices.length;
        for (int i = 0; i < days-1; i++) {
            for (int j = i+1; j < days; j++) {
                profit = Math.max(profit,prices[j]-prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] prices = {7,1,5,3,6,4};

        int[] prices = {7,6,4,3,1};

        System.out.println(solution.maxProfit(prices));
    }
}
