package LeetCode.Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 */
public class Solution {

    /**
     * 贪心
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int remove = 0;
        int left = 0;
        int right = 1;

        while (right < intervals.length) {
            if (intervals[left][1] <= intervals[right][0])
                left = right;
            else if (intervals[left][1] <= intervals[right][1])
                remove++;
            else {
                left = right;
                remove++;
            }
            right++;
        }
        return remove;
    }
}
