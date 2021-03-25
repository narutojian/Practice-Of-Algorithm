package LeetCode.Jump_Game;

import java.util.Arrays;

/**
 * 55. Jump Game
 */
public class Solution {

    /**
     * dp 递归 记忆化
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return isExist(nums,n-1,memo) == 1 ? true : false;
    }

    private int isExist(int[] nums,int i,int[] memo) {
        if (i == 0)
            return 1;
        if (memo[i] != -1)
            return memo[i];

        for (int j = i-1; j > -1; j--) {
            if (nums[j] >= (i-j) && isExist(nums,j,memo) == 1) {
                memo[i] = 1;
                return memo[i];
            }
        }
        memo[i] = 0;
        return memo[i];
    }
}
