package LeetCode.Minimum_Path_Sum;

import java.util.Arrays;

public class Solution2 {

    /**
     * dp 滚动数组
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        Arrays.fill(prev,Integer.MAX_VALUE);
        cur[0] = Integer.MAX_VALUE;
        prev[1] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                cur[j] = Math.min(prev[j],cur[j-1])+grid[i-1][j-1];
            }
            for (int j = 1; j < n + 1; j++) {
                prev[j] = cur[j];
            }
        }
        return prev[n];
    }
}
