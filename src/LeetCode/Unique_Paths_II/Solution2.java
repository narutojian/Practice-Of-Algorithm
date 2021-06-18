package LeetCode.Unique_Paths_II;

public class Solution2 {

    /**
     * dp 滚动数组
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];
        int[] cur = new int[n];
        prev[0] = 1;
        // 初始化 prev
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                prev[i] = 0;
            else if (i != 0) {
                prev[i] = prev[i-1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    cur[j] = 0;
                else {
                    cur[j] = prev[j] + (j-1 < 0 ? 0 : cur[j-1]);
                }
            }
            // 更新prev
            for (int j = 0; j < n; j++) {
                prev[j] = cur[j];
            }
        }
        return prev[n-1];
    }
}
