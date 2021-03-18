package LeetCode.maximum_subarray;

public class Solution3 {

    /**
     * 暴力搜索 O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = i; j < n; j++) {
                curSum += nums[j];
                res = Math.max(res,curSum);
            }
        }
        return res;
    }
}
