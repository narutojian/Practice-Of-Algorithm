package LeetCode;

public class P62 {
    /**
     * 动态规划
     * @param m 行
     * @param n 列
     * @return 不同路径数量
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        int i,j;
        for (i = 1; i < m; i++) dp[i][0] = 1;
        for (i = 1; i < n; i++) dp[0][i] = 1;

        for (i = 1; i < m; i++) {
            for (j = 1;j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        P62 h = new P62();
        int m = 3;
        int n = 3;
        System.out.println(h.uniquePaths(m,n));
    }
}
