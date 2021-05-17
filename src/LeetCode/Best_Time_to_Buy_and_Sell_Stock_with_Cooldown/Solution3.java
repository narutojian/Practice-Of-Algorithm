package LeetCode.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution3 {

    /**
     * dp 空间优化
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int[3];
        int[] cur = new int[3];
        prev[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            cur[0] = Math.max(prev[0],prev[2]-prices[i]);
            cur[1] = prev[0]+prices[i];
            cur[2] = Math.max(prev[1],prev[2]);
            for (int j = 0; j < 3; j++) {
                prev[j] = cur[j];
            }
        }

        return Math.max(cur[0],Math.max(cur[1],cur[2]));
    }
}
