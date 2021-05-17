package LeetCode.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class Solution {

    private int n;

    /**
     * 暴力模拟
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        n = prices.length;
        return Math.max(buySell(prices,0,-1),buySell(prices,0,0));
    }

    private int buySell(int[] prices,int start,int buy) {
        if (start >= n)
            return 0;
        if (buy == -1) {
            return Math.max(buySell(prices,start+1,start),buySell(prices,start+1,buy));
        }
        return Math.max(buySell(prices,start+2,-1)+(prices[start]-prices[buy]),buySell(prices,start+1,buy));
    }
}
