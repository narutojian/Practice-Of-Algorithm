package LeetCode.Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */
public class Solution {

    /**
     * 贪心
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] > o2[0] ? 1 : -1;
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        int res = 0;
        Integer left = null;// 记录重叠区间 [left,right]
        Integer right = null;
        for (int i = 0; i < n; i++) {
            if (left == null) {
                left = points[i][0];
                right = points[i][1];
            }
            else {
                if (right >= points[i][0]) {
                    left = points[i][0];
                    right = Math.min(right,points[i][1]);
                }
                else {
                    res++;
                    left = points[i][0];
                    right = points[i][1];
                }
            }
        }
        if (left != null)
            res++;
        return res;
    }
}
