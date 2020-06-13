package LeetCode.merge_intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class Solution {

    /**
     * 排序后 在进行合并区间
     * @param intervals 区间数组
     * @return 合并后的区间数组
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return intervals;
        List<int[]> ans = new ArrayList<>();
        sortArray(intervals,0,intervals.length-1);

        ans.add(intervals[0].clone());

        for (int i = 1; i < intervals.length; i++) {
            int[] temp = ans.get(ans.size()-1);
            if (temp[1] >= intervals[i][0] && intervals[i][1] > temp[1]) {
                temp[1] = intervals[i][1];
                ans.remove(ans.size()-1);
                ans.add(temp.clone());
            }
            else if (temp[1] < intervals[i][0]) {
                ans.add(intervals[i].clone());
            }
        }
        return ans.toArray(new int[0][]);
    }

    /*
    快速排序
     */
    private void sortArray(int[][] arr,int start,int end) {
        if (start >= end) return;
        int[] point = arr[start].clone();
        int low = start;
        int high = end;

        while (low < high) {
            while (low < high && arr[high][0] >= point[0]) {
                high--;
            }
            if (low < high) {
                assign(arr,low,high);
                low++;
            }
            while (low < high && arr[low][0] < point[0]) {
                low++;
            }
            if (low < high) {
                assign(arr,high,low);
                high--;
            }
        }

        arr[low][0] = point[0];
        arr[low][1] = point[1];

        sortArray(arr,start,low-1);
        sortArray(arr,low+1,end);
    }

    private void assign(int[][] arr,int target,int assignValue) {
        if (target == assignValue) return;
        arr[target][0] = arr[assignValue][0];
        arr[target][1] = arr[assignValue][1];
    }

    public static void main(String[] args) {
        Solution h = new Solution();
//        int[][] intervals = {
//                {1,3},{2,6},{8,10},{15,18}
//        };
        int[][] intervals = {
                {1,4},{0,4}
        };
        int[][] ans = h.merge(intervals);

        for (int[] an : ans) {
            System.out.print("[" + an[0] + "," + an[1] + "]\t");
        }
        System.out.println();
    }
}
