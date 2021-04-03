package LeetCode.Longest_Common_Subsequence;

public class Solution4 {

    /**
     * dp 迭代
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];// 定义 dp[i][j] text1的前i个字符 与 text2的前j个字符最长公共子序列长度

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}
