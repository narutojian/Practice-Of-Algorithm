package LeetCode.minimum_cost_for_tickets;

public class Solution2 {

    /**
     * 贪心 解答错误
     * 贪心策略为
     * 为了让每一个旅行的日期的花费尽量低
     * 对于三种cost，计算在当前cost为i的情况下，实际覆盖了days中的几个旅行日。
     * 令当前cost为i，实际旅行日为j，那么得出avg = i/j; 表明每一天的平均花费
     * 然后找出其中最小的avg，选择此cost的方案。
     * @param days 旅行日期
     * @param costs 花费方案
     * @return 最小旅行费用
     */
    public int mincostTickets(int[] days, int[] costs) {
        int ans = 0;
        int[] len = {1,7,30};
        int start = 0,temp,j,nextIndex = 0;
        double minAvg;
        int[] index = new int[3];
        double[] avg = new double[3];

        while (start < days.length) {
            for (int i = 0; i < 3; i++) {
                temp = len[i]+days[start]-1;
                j = start+1;
                while (j < days.length && days[j] <= temp) j++;
                index[i] = j;
            }
            minAvg = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                avg[i] = costs[i]*1.0/(index[i] - start);
                if (minAvg >= avg[i]) {
                    minAvg = avg[i];
                    nextIndex = i;
                }
            }
            ans += costs[nextIndex];
            start = index[nextIndex];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

//        int[] days = {1,4,6,7,8,20};
//        int[] costs = {2,7,15};

        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = {3,13,45};

        System.out.println(h.mincostTickets(days,costs));
    }
}
