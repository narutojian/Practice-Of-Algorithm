package LeetCode.Unique_Paths_II;

/**
 * 63. Unique Paths II
 */
public class Solution {

    /**
     * dp
     * dp[i][j] 表示从(0,0)到(i,j)的所有路径数
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i != 0 || j != 0){
                    dp[i][j] = (i-1 < 0 ? 0 : dp[i-1][j]) + (j-1 < 0 ? 0 : dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
