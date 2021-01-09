package LeetCode.Best_Time_to_Buy_and_Sell_Stock;

public class Solution2 {

    /**
     * 将数组进行分区间
     * 在当前买入股票的位置起，记为start；找到之后股票价格最高的那一天，记为end
     * 然后在start与end之间遍历，找到最大利润（就是找到区间中股票价格最小的点）
     * 该区间遍历完后，start= end+1,然后从此起点出发，找到之后股票价格最高的那一天，记为end，
     * 继续求出最大利润；
     * 重复上述步骤，直到最后
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int days = prices.length;
        int start = 0;
        int maxIndex;
        for (int i = 0; i < days - 1; i++) {
            if (prices[i] < prices[i+1]) {
                start = i;
                break;
            }
        }
        maxIndex = start;
        for (int i = start; i < days; i++) {
            if (maxIndex == i && i != days-1) {
                maxIndex = i+1;
                for (int j = maxIndex+1; j < days; j++) {
                    if (prices[j] >= prices[maxIndex]) {
                        maxIndex = j;
                    }
                }
                start = i;
                profit = Math.max(profit,prices[maxIndex] - prices[i]);
            }
            else {
                if (prices[i] < prices[start]) {
                    profit = Math.max(profit,prices[maxIndex] - prices[i]);
                    start = i;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        int[] prices = {7,1,5,3,6,4};

//        int[] prices = {7,6,4,3,1};

        int[] prices = {1,2};

        System.out.println(solution2.maxProfit(prices));
    }
}
