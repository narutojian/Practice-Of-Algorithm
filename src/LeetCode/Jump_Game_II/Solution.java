package LeetCode.Jump_Game_II;

import java.util.Arrays;

/**
 * 45. Jump Game II
 */
public class Solution {

    /**
     * dp 递归 记忆化
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return getMinStep(nums,memo,n-1);
    }

    private int getMinStep(int[] nums,int[] memo,int i) {
        if (i == 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        memo[i] = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (j+nums[j] >= i)
                memo[i] = Math.min(memo[i],1+getMinStep(nums,memo,j));
        }
        return memo[i];
    }
}
