package LeetCode.Maximum_Product_Subarray;

/**
 * 152. Maximum Product Subarray
 */
public class Solution {

    /**
     * 暴力枚举
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = i; j < n; j++) {
                cur *= nums[j];
                res = Math.max(res,cur);
            }
        }
        return res;
    }
}
