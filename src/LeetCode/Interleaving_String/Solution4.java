package LeetCode.Interleaving_String;

public class Solution4 {

    /**
     * dp
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
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i < m+1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = 1;
            else break;
        }
        for (int i = 1; i < n + 1; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = 1;
            else break;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (dp[i-1][j] == 1 && s1.charAt(i-1) == s3.charAt(i+j-1))
                    dp[i][j] = 1;
                if (dp[i][j-1] == 1 && s2.charAt(j-1) == s3.charAt(i+j-1))
                    dp[i][j] = 1;
            }
        }

        return dp[m][n] == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(solution4.isInterleave(s1,s2,s3));
    }
}
