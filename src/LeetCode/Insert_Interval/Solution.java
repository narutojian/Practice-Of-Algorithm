package LeetCode.Insert_Interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class Solution {

    /**
     * 官方题解 模拟
     * 时间复杂度 O(n) 空间复杂度O(n)
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        int n = intervals.length;
//        if (n == 0) return new int[][]{{newInterval[0],newInterval[1]}};
        boolean placed = false;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        for (; i < n; i++) {
            // 当前的区间在前
            if (intervals[i][1] < newStart) {
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else if (newEnd < intervals[i][0]) { // 当前的区间在后
                list.add(new int[]{newStart,newEnd});
//                newStart = -1;
                placed = true;
                break;
            }
            else { // 有重叠
                newStart = Math.min(newStart,intervals[i][0]);
                newEnd = Math.max(newEnd,intervals[i][1]);
            }
        }
//        if (newStart != -1) {
//            list.add(new int[]{newStart,newEnd});
//        }
        if (!placed) list.add(new int[]{newStart,newEnd});
        for (;i < n;i++) {
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test1
//        int[][] intervals = {
//                {1,3},
//                {6,9}
//        };
//        int[] newInterval = {2,5};
        // test2
//        int[][] intervals = {
//                {1,2},
//                {3,5},
//                {6,7},
//                {8,10},
//                {12,16}
//        };
//        int[] newInterval = {4,8};
        // test3
//        int[][] intervals = {
//        };
//        int[] newInterval = {5,7};
        // test4
//        int[][] intervals = {
//                {1,5}
//        };
//        int[] newInterval = {2,3};
        // test4
//        int[][] intervals = {
//                {1,5}
//        };
//        int[] newInterval = {2,7};
        // test5
//        int[][] intervals = {
//                {0,5},
//                {9,12}
//        };
//        int[] newInterval = {7,16};
        // test6
        int[][] intervals = {
                {1,5}
        };
        int[] newInterval = {6,8};
        int[][] ans = solution.insert(intervals,newInterval);

        for (int[] i :
                ans) {
            System.out.println(Arrays.toString(i));
        }
    }
}
