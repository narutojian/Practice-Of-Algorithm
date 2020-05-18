package LeetCode.minimum_cost_for_tickets;

public class Solution4 {

    /**
     * 动态规划 从前往后
     * 比上一个动态规划的代码简洁
     * @param days 旅行日期
     * @param costs 花费方案
     * @return 最小花费
     */
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        int start = days[0],pos = 1; // pos为days的索引值，表明下一个旅行日期的索引
        dp[start] = Math.min(costs[0],Math.min(costs[1],costs[2]));// 初始化

        for (start += 1;start < dp.length;start++) {
            if (start != days[pos]) dp[start] = dp[start-1];
            else {
                dp[start] = Math.min(dp[start-1]+costs[0],Math.min(dp[Math.max(start - 7, 0)]+costs[1],dp[Math.max(start - 30, 0)]+costs[2]));
                pos++;
            }
        }
        return dp[days[n-1]];
    }

    public static void main(String[] args) {
        Solution4 h = new Solution4();

        int[] days = {1,4,6,7,8,20};
        int[] costs = {7,2,15};

        System.out.println(h.mincostTickets(days,costs));
    }
}
