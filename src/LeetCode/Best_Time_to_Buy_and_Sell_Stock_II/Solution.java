package LeetCode.Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class Solution {
    /**
     * 自己用脑子想的 觉得这个方法叫双指针不错
     * 但是官方题解中把这种思想称为贪心算法
     * 想想也是 每次都是局部最优
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int cur = prices[0];// 买入的价钱
        int curMax = prices[0]; // 最大的卖出价格

        for (int i = 1; i < prices.length; i++) {
            // 没有比之前遇到的价格高的了 赶紧出手
            if (prices[i] < curMax) {
                // 进行一次交易
                max += curMax - cur;
                // 更新
                cur = prices[i];
            }
            // 价格高的就保留下来
            curMax = prices[i];
        }
        // 最后一次交易
        max += curMax - cur;
        return max;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

//        int[] prices = {7,1,5,3,6,4};

//        int[] prices = {1,2,3,4,5};

//        int[] prices = {7,6,4,3,1};

        int[] prices = {1,2};
        System.out.println(solution.maxProfit(prices));
    }
}
