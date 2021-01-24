package LeetCode.Longest_Continuous_Increasing_Subsequence;

/**
 * 674. Longest Continuous Increasing Subsequence
 */
public class Solution {

    /**
     * dp
     * dp[i]: 表示在nums以索引i结尾的位置上连续的递增序列的最大长度
     * 转移方程：
     * dp[i] = dp[i-1]+1 (nums[i] > nums[i-1])
     * dp[i] = 1 (nums[i] <= nums[i-1])
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int pre = 0,cur;

        for (int i = 0; i < nums.length; i++) {
            cur = 1;
            if (i > 0 && nums[i] > nums[i-1])
                cur += pre;
            res = Math.max(res,cur);
            pre = cur;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {1,3,5,4,7};

//        int[] nums = {2,2,2,2,2,2};

//        int[] nums = {};

        int[] nums = {4,7,1,3,5};

        System.out.println(solution.findLengthOfLCIS(nums));
    }
}
