package LeetCode.longest_increasing_subsequence;

import java.util.Arrays;

public class Solution4 {

    private int n;
    private int[] dp;

    /**
     * 递归 记忆化
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,getLength(nums,i));
        }
        return res;
    }

    private int getLength(int[] nums,int endPoint) {
        if (endPoint == 0)
            return 1;
        if (dp[endPoint] != -1)
            return dp[endPoint];
        dp[endPoint] = 1;
        for (int i = endPoint-1; i > -1; i--) {
            if (nums[endPoint] > nums[i]) {
                dp[endPoint] = Math.max(dp[endPoint],1+getLength(nums,i));
            }
        }
        return dp[endPoint];
    }
}
