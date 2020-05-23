package LeetCode.coin_lcci;

/**
 * 面试题 08.11. Coin LCCI
 */
public class Solution {
    /**
     * 动态规划 背包问题
     * f(i,v) 表示用前i种币组成v值的方案数
     * 状态转移方程：f(i,v) = f(i-1,v-0*ci)+f(i-1,v-ci)+...+f(i-1,v-k*ci),其中 k = v/ci 向下取整
     * 可以在进行空间和时间上的优化
     * @param n 输入
     * @return 方案数
     */
    public int waysToChange(int n) {
        int[][] dp = new int[4][n+1];
        // 初始化
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        int[] choice = {1,5,10,25};

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n+1; j++) {
                if (j - choice[i] >= 0)
                    dp[i][j] = dp[i-1][j]+dp[i][j-choice[i]];
                else dp[i][j] = dp[i-1][j];
                dp[i][j] %= 1000000007;
            }
        }
        return dp[3][n];
    }
}
