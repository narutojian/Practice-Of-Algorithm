package LeetCode.Partition_Equal_Subset_Sum;

public class Solution3 {

    /**
     * dp 迭代
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 == 1)
            return false;
        int target = total/2;
        boolean[][]dp = new boolean[n+1][target+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j - nums[i] < 0)
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][target];
    }
}
