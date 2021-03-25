package LeetCode.Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    /**
     * 贪心 找出最大的无交集的区间数
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        int res = 0;
        Integer end = null;
        for (int i = 0; i < n; i++) {
            if (end == null)
                end = points[i][1];
            else {
                if (end < points[i][0]) {
                    res++;
                    end = points[i][1];
                }
            }
        }
        if (end != null)
            res++;
        return res;
    }
}
