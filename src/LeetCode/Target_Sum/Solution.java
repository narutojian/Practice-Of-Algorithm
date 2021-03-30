package LeetCode.Target_Sum;

import java.util.Arrays;

/**
 * 494. Target Sum
 */
public class Solution {

    private int offset;// 偏移量

    /**
     * dp 递归 记忆化
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int maxVal = 0;
        int minVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal += nums[i];
            minVal -= nums[i];
        }
        offset = -(S+minVal);
        int[][] memo = new int[n+1][S+maxVal+offset+1];
        for (int[] row : memo) {
            Arrays.fill(row,-1);
        }
        int res = getNum(nums,S+offset,n,memo);
        return res;
    }

    private int getNum(int[] nums,int target,int i,int[][] memo) {
        if (i == 0 && target-offset == 0)
            return 1;
        if (i == 0 && target-offset != 0)
            return 0;
        if (memo[i][target] != -1)
            return memo[i][target];
        memo[i][target] = getNum(nums,target-nums[i-1],i-1,memo)+getNum(nums,target+nums[i-1],i-1,memo);
        return memo[i][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,1,1,1};
        int S = 3;

        System.out.println(solution.findTargetSumWays(nums,S));
    }
}
