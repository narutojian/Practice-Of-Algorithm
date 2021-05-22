package LeetCode.Find_Kth_Largest_XOR_Coordinate_Value;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1738. Find Kth Largest XOR Coordinate Value
 */
public class Solution {

    /**
     * dp
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 > o1 ? 1 : -1;
            }
        });
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        queue.add(dp[0][0]);
        //初始化
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1]^matrix[0][i];
            queue.add(dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0]^matrix[i][0];
            queue.add(dp[i][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i][j];
                queue.add(dp[i][j]);
            }
        }
        while (k > 1) {
            queue.remove();
            k--;
        }
        return queue.remove();
    }
}
