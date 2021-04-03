package LeetCode.Longest_Common_Subsequence;

public class Solution5 {

    /**
     * dp 状态压缩
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] pre = new int[m+1];// (i-1)层
        int[] cur = new int[m+1];// i 层

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    cur[j] = pre[j-1]+1;
                else cur[j] = Math.max(cur[j-1],pre[j]);
            }
            // 更新 (i-1) 层 为 i 层
            for (int j = 0; j < m + 1; j++) {
                pre[j] = cur[j];
            }
        }
        return cur[m];
    }
}
