package LeetCode.Longest_Common_Subsequence;

import java.util.Arrays;

public class Solution3 {

    private int m;
    private int n;
    private int[][] memo;

    /**
     * 递归 记忆化 优化
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row,-1);
        }
        return getLength(text1,0,text2,0);
    }

    private int getLength(String text1,int i,String text2,int j) {
        if (i == m || j == n)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1+getLength(text1,i+1,text2,j+1);
        }
        else {
            memo[i][j] = Math.max(getLength(text1,i+1,text2,j),getLength(text1,i,text2,j+1));
        }
        return memo[i][j];
    }
}
