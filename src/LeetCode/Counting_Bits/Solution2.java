package LeetCode.Counting_Bits;

public class Solution2 {

    /**
     * 动态规划
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num+1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[(i >> 1)]+(i&1);
        }
        return dp;
    }
}
