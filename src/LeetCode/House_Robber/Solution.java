package LeetCode.House_Robber;

/**
 * 198. House Robber
 */
public class Solution {

    /**
     * dp
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i]: 表示最后一家偷的是nums[i]的最大金钱数
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i - 2 > -1) {
                dp[i] = Math.max(dp[i], dp[i - 2] + nums[i]);
            }
            if (i - 3 > -1) {
                dp[i] = Math.max(dp[i], dp[i - 3] + nums[i]);
            }
        }
        int res = dp[n-1];
        if (n-2 > -1)
            res = Math.max(res,dp[n-2]);
        return res;
    }
}
