package LeetCode.Longest_Palindromic_Subsequence;

import java.util.Arrays;

public class Solution2 {

    private  int n;
    private int[][] dp;

    /**
     * 递归 记忆化
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getLongest(s,0,n-1);
    }

    private int getLongest(String s,int left,int right) {
        if (left > right)
            return 0;
        if (left == right)
            return 1;
        if (dp[left][right] != -1)
            return dp[left][right];
        if (s.charAt(left) == s.charAt(right)) {
            dp[left][right] = 2+getLongest(s,left+1,right-1);
        }
        else {
            dp[left][right] = Math.max(getLongest(s,left+1,right),getLongest(s,left,right-1));
        }
        return dp[left][right];
    }
}
