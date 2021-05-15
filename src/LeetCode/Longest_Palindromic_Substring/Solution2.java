package LeetCode.Longest_Palindromic_Substring;

public class Solution2 {

    /**
     * dp
     * dp[i][j] : 表示 s的[i,j]字符串 是否为回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        String ans = s.substring(0,1);
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i > -1; i--) {
            for (int j = i; j < n; j++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                if (i == j)
                    dp[i][j] = true;
                else if (j == i+1 && flag)
                    dp[i][j] = true;
                else dp[i][j] = dp[i+1][j-1] && flag;
                if (dp[i][j] && maxLen < (j-i+1)) {
                    maxLen = j-i+1;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}
