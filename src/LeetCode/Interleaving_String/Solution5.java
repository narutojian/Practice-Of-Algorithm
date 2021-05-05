package LeetCode.Interleaving_String;

public class Solution5 {

    /**
     * dp 空间优化
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

        boolean[] prev = new boolean[n+1];// 第i-1 层
        boolean[] cur = new boolean[n+1];// 第 i层
        boolean[] temp = new boolean[m+1];// 表示 dp[i][0]

        // 初始化
        prev[0] = true;
        temp[0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1))
                temp[i] = true;
            else break;
        }

        for (int i = 1; i < n + 1; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1))
                prev[i] = true;
            else break;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (j == 0)
                    cur[j] = temp[i];
                else if ((prev[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (cur[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)))
                    cur[j] = true;
                else cur[j] = false;
            }
            for (int j = 0; j < n+1; j++) {
                prev[j] = cur[j];
            }
        }
        return prev[n];
    }
}
