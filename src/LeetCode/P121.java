package LeetCode;

public class P121 {
    /**
     * 暴力枚举比较
     * @param prices 输入
     * @return 输出
     */
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE,temp;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] < prices[i]) continue;
                temp = prices[j] - prices[i];
                if (ans < temp) ans = temp;
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


}
