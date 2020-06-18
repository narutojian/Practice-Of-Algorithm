package LeetCode.longest_increasing_subsequence;

/**
 * 300. Longest Increasing Subsequence
 */
public class Solution {

    /**
     * 动态规划
     * dp[i]: 以nums[i]结尾的上升子序列的最大长度
     * @param nums 数组序列
     * @return 返回最长上升子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution h = new Solution();

//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {10,9,2,5,3,4};

        System.out.println(h.lengthOfLIS(nums));
    }
}
