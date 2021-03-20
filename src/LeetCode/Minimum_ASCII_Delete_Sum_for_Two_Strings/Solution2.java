package LeetCode.Minimum_ASCII_Delete_Sum_for_Two_Strings;

import java.util.Arrays;

public class Solution2 {

    private int m;
    private int n;
    private int[][] dp;

    /**
     * 递归 记忆化
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinVal(s1,0,s2,0);
    }

    private int getMinVal(String s1,int i,String s2,int j) {
        int val = 0;
        if (i == m) {
            for (int k = j; k < n; k++) {
                val += s2.charAt(k);
            }
            return val;
        }
        if (j == n) {
            for (int k = i; k < m; k++) {
                val += s1.charAt(k);
            }
            return val;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = getMinVal(s1,i+1,s2,j+1);
        }
        else {
            dp[i][j] = Math.min(s1.charAt(i)+getMinVal(s1,i+1,s2,j),s2.charAt(j)+getMinVal(s1,i,s2,j+1));
        }

        return dp[i][j];
    }
}
