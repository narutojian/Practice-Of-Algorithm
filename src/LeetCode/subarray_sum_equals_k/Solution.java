package LeetCode.subarray_sum_equals_k;

/**
 * 560. Subarray Sum Equals K
 */
public class Solution {

    /**
     * 暴力解法
     * @param nums 数组
     * @param k 目标值
     * @return 可以组成k的子数组个数
     */
    public int subarraySum(int[] nums, int k) {
       int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
