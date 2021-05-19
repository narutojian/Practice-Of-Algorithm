package LeetCode.Find_Kth_Largest_XOR_Coordinate_Value;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    /**
     * dp 空间优化
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

        int[] prev = new int[n];
        int[] cur = new int[n];
        prev[0] = matrix[0][0];
        queue.add(prev[0]);
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i-1]^matrix[0][i];
            queue.add(prev[i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = prev[j]^matrix[i][j];
                }
                else cur[j] = prev[j]^prev[j-1]^cur[j-1]^matrix[i][j];
                queue.add(cur[j]);
            }
            for (int j = 0; j < n; j++) {
                prev[j] = cur[j];
            }
        }
        while (k > 1) {
            queue.remove();
            k--;
        }
        return queue.remove();
    }
}
