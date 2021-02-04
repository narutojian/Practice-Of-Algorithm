package LeetCode.Maximum_Average_Subarray_I;

public class Solution2 {

    /**
     * 滑动窗口
     * 计算出最大的连续子数组的和就行 不需要每次都计算出平均值
     * 最大的子数组和的平均值一定是最大的
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i > k-1) {
                curSum -= nums[start];
                start++;
            }
            if (i > k-2)
                maxSum = Math.max(maxSum,curSum);
        }
        return maxSum*1.0/k;
    }
}
