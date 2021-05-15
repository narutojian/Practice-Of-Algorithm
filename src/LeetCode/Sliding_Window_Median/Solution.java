package LeetCode.Sliding_Window_Median;

import java.util.Arrays;

/**
 * 480. Sliding Window Median
 */
public class Solution {

    /**
     * 暴力解法 超时
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int mid = (k-1)/2;
        double[] res = new double[n-k+1];
        boolean even = k%2 == 0 ? true : false;

        double median;
        for (int i = 0; i < n - k + 1; i++) {
            int[] temp = Arrays.copyOfRange(nums,i,i+k);
            Arrays.sort(temp);
            median = temp[mid];
            if (even) {
                median += temp[mid+1];
                median /= 2;
            }
            res[i] = median;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums,k)));
    }
}
