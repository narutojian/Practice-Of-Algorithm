package LeetCode.Maximal_Square;

public class Solution3 {

    /**
     * 优化 dp
     * 如果matrix[i][j]为 1,那么转化方程为
     * dp[i][j] = min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]}+1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else {
                    if (matrix[i][j] == '1')
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;
    }
}
