package LeetCode.minimum_cost_for_tickets;

/**
 * 983. Minimum Cost For Tickets
 */
public class Solution {
    private int ans = Integer.MAX_VALUE;
    private int[] len = {1,7,30};

    /**
     * DFS 超时
     * @param days 旅行的日期
     * @param costs 花费方案
     * @return 最小旅行花费
     */
    public int mincostTickets(int[] days, int[] costs) {
        dfs(days,costs,0,0);
        return ans;
    }

    private void dfs(int[] days,int[] costs,int start,int curCost) {
        if (curCost >= ans) return;
        if (start >= days.length) {
            ans = curCost;
            return;
        }
        int[] index = new int[3];
        int temp,j;
        for (int i = 0; i < 3; i++) {
            temp = len[i]+days[start]-1;
            if (i != 0) j = index[i-1];
            else j = start+1;
            while (j < days.length && days[j] <= temp) j++;
            index[i] = j;
        }

        for (int i = 0; i < 3; i++) {
            dfs(days,costs,index[i],curCost+costs[i]);
        }
    }

    public static void main(String[] args) {
        Solution h = new Solution();

//        int[] days = {1,2,4,5,6,8,9,10,11,12,14,15,16,18,19,21,22,25,28,29,30,31,35,36,37,38,39,40,41,42,44,45,47,48,50,52,54,56,59,60,62,63,64,67,68,69,70,72,74,76,77,79,80,82,83,84,86,87,91,95,96,98};
//        int[] costs = {5,20,86};

        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = {3,13,45};

        System.out.println(h.mincostTickets(days,costs));
    }
}
