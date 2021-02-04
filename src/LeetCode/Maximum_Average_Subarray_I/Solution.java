package LeetCode.Maximum_Average_Subarray_I;

/**
 * 643. Maximum Average Subarray I
 */
public class Solution {

    /**
     * 滑动窗口 双指针
     * 每次计算一次平均值 更新最大平均值
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAve = -400000000;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i > k-1) {
                sum -= nums[start];
                start++;
            }
            if (i > k-2)
                maxAve = Math.max(maxAve,sum*1.0/k);
        }
        return maxAve;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-1};
        int k = 1;

        System.out.println(solution.findMaxAverage(nums,k));
    }
}
