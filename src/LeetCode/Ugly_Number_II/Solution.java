package LeetCode.Ugly_Number_II;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II
 */
public class Solution {

    /**
     * 暴力枚举
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[] multiple = {2,3,5};
        int[] maxVal = {1073741824,715827883,429496730};
        set.add(1);
        queue.add(1);
        int cnt = 0; // 计数器

        while (cnt < n-1) {
            int cur = queue.remove();
            for (int i = 0; i < 3; i++) {
                if (cur >= maxVal[i])
                    break;
                int node = cur*multiple[i];
                if (set.add(node)) {
                    queue.add(node);
                }
            }
            cnt++;
        }
        return queue.remove();
    }
}
