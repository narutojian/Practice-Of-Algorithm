package LeetCode.Longest_Common_Subsequence;

import java.util.Arrays;

public class Solution2 {

    private int n1;
    private int n2;

    /**
     * 递归 记忆化
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        int[][] dp = new int[n1][n2+1];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(dp[i],-1);
        }

        int res = 0;
        for (int i = 0; i < n1; i++) {
            res = Math.max(res,getCommonLength(text1,text2,i,0,dp));
        }
        return res;
    }

    private int getCommonLength(String text1,String text2,int index1,int index2,int[][] dp) {
        if (index1 == n1 || index2 == n2)
            return 0;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (text1.charAt(index1) == text2.charAt(index2)) {
            int max = 1;
            for (int i = index1+1; i < n1; i++) {
                dp[i][index2+1] = getCommonLength(text1,text2,i,index2+1,dp);
                max = Math.max(max,1+dp[i][index2+1]);
            }
            dp[index1][index2] = max;
        }
        else dp[index1][index2] = getCommonLength(text1,text2,index1,index2+1,dp);

        return dp[index1][index2];
    }
}
