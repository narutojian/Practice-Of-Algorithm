package LeetCode.Interleaving_String;

import java.util.Arrays;

public class Solution3 {
    private int m;
    private int n;
    private int len;

    /**
     * dfs+记忆化
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        len = s3.length();

        if (m+n != len)
            return false;
        int[][] memo = new int[m+1][n+1];// memo[i][j]表示 s1的前i个字符与s2的前j个字符，能否交错组成s3的前(i+j)个字符
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return isCompose(s1,m,s2,n,s3,len,memo);
    }

    private boolean isCompose(String s1,int i,String s2,int j,String s3,int k,int[][] memo) {
        if (i == 0 && j == 0 && k == 0)
            return true;
        if (memo[i][j] != -1)
            return memo[i][j] == 1 ? true : false;
        memo[i][j] = 0;
        if (i > 0) {
            if (s1.charAt(i-1) == s3.charAt(k-1)) {
                memo[i][j] = isCompose(s1,i-1,s2,j,s3,k-1,memo) ? 1 : 0;
            }
        }
        if (j > 0) {
            if (s2.charAt(j-1) == s3.charAt(k-1)) {
                if (memo[i][j] != 1) {
                    memo[i][j] = isCompose(s1,i,s2,j-1,s3,k-1,memo) ? 1: 0;
                }
            }
        }
        return memo[i][j] == 1 ? true : false;
    }
}
