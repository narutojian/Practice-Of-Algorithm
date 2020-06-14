package LeetCode.subarray_sum_equals_k;

/**
 * 560. Subarray Sum Equals K
 */
public class Solution {

    /**
     * 暴力枚举
     * @param nums 数组
     * @param k target value
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0,sum;

        for (int i = nums.length-1; i >= 0; i--) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
