package LeetCode.Find_Kth_Largest_XOR_Coordinate_Value;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {

    /**
     * 代码优化
     * 任何值 异或 0 都为自身
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
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                cur[j] = prev[j]^prev[j-1]^cur[j-1]^matrix[i-1][j-1];
                queue.add(cur[j]);
            }
            for (int j = 1; j < n + 1; j++) {
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
