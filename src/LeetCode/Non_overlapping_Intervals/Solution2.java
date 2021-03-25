package LeetCode.Non_overlapping_Intervals;

import java.util.Arrays;

public class Solution2 {

    /**
     * dp 递归 记忆化
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,getNum(intervals,memo,i,n));
        }

        return n-res;
    }

    private int getNum(int[][] intervals,int[] memo,int i,int n) {
        if (memo[i] != -1)
            return memo[i];
        int max = 1;
        for (int j = 0; j < n; j++) {
            if (j == i) continue;
            if (intervals[j][1] <= intervals[i][0])
                max = Math.max(max,getNum(intervals,memo,j,n)+1);
        }
        memo[i] = max;
        return memo[i];
    }
}
