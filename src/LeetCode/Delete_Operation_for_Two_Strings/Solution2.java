package LeetCode.Delete_Operation_for_Two_Strings;

import java.util.Arrays;

public class Solution2 {

    private int m;
    private int n;
    private int[][] dp;

    /**
     * 递归 记忆化
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinOperations(word1,0,word2,0);
    }

    private int getMinOperations(String word1,int i,String word2,int j) {
        if (i == m)
            return n-j;
        if (j == n)
            return m-i;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = getMinOperations(word1,i+1,word2,j+1);
        }
        else {
            dp[i][j] = Math.min(getMinOperations(word1,i+1,word2,j),getMinOperations(word1,i,word2,j+1))+1;
        }
        return dp[i][j];

    }
}
