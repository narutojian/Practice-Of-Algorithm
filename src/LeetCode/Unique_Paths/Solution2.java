package LeetCode.Unique_Paths;

import java.util.Arrays;

public class Solution2 {

    /**
     * dp 状态压缩
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] cur = new int[n];
        Arrays.fill(prev,1);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = prev[j];
                }
                else cur[j] = prev[j]+cur[j-1];
            }
            for (int j = 0; j < n; j++) {
                prev[j] = cur[j];
            }
        }
        return prev[n-1];
    }
}
