package LeetCode;

/**
 * 面试题 17.16. 按摩师
 */
public class P1496 {

    /**
     * 动态规划
     * dp[i] 表示到第i个预约者时最大的预约时间总和
     * dp[i] = Math.max(dp[i][0],dp[i][1]);
     * dp[i][0] 代表到第i个预约者不选择该预约者时最大的预约时间总和
     * dp[i][1] 代表到第i个预约者选择该预约者时最大的预约时间总和
     * 递推公式：
     * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
     * dp[i][1] = dp[i-1][0] + nums[i]
     * @param nums 预约请求序列
     * @return 最大预约时间总和
     */
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    /**
     * 动态规划 优化空间复杂度为O(1)
     * @param nums 预约请求序列
     * @return 最大预约时间总和
     */
    public int massage_Solution2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int preSelected = nums[0],preNotSelect = 0,curSelected = 0,curNotSelect = 0;
        for (int i = 1; i < nums.length; i++) {
            curNotSelect = Math.max(preSelected,preNotSelect);
            curSelected = preNotSelect+nums[i];
            preNotSelect = curNotSelect;
            preSelected = curSelected;
        }
        return Math.max(curSelected,curNotSelect);
    }
}
