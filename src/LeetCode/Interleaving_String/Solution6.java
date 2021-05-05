package LeetCode.Interleaving_String;

public class Solution6 {

    /**
     * dp 空间究极优化
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int len = s3.length();

        if (m+n != len)
            return false;

        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                int pos = i+j-1;
                // dp[i][j] = dp[i-1][j] && s1[i-1] == s3[pos]
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(pos);
                }
                // dp[i][j] = dp[i][j-1] && s2[j-1] == s3[pos]
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j-1] && s2.charAt(j-1) == s3.charAt(pos));
                }
            }
        }

        return dp[n];
    }
}
