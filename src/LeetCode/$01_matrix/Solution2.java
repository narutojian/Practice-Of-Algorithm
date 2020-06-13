package LeetCode.$01_matrix;

public class Solution2 {
    /**
     * 动态规划
     * dp[i][j]表示点(i,j)到最近的点的最短距离
     * @param matrix 01矩阵
     * @return 距离矩阵
     */
    public int[][] updateMatrix(int[][] matrix) {
        // 用一个二维数组引用matrix，主要是dp的名字好懂些
        int[][] dp = matrix;
        int n = dp.length;
        int m = dp[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 1) {
                    // 对1的点进行赋值，初始值为比较大的值
                    dp[i][j] = Integer.MAX_VALUE/2;
                }
            }
        }

        // 从左上角遍历，此时左边和上边的dp已经保存，即为之前的状态，当前的状态可以使用之前的状态进行递推
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i -1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j],1+dp[i-1][j]);
                }
                if (j-1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j],1+dp[i][j-1]);
                }
            }
        }

        // 从右下角遍历，此时右边和下边的dp已经保存，即为之前的状态，当前的状态可以使用之前的状态进行递推
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i+1 < n) {
                    dp[i][j] = Math.min(dp[i][j],1+dp[i+1][j]);
                }
                if (j+1 < m) {
                    dp[i][j] = Math.min(dp[i][j],1+dp[i][j+1]);
                }
            }
        }

        // 经过左上和右下的递推，可以确定了一个点的四个方位的最短路径
        return dp;
    }
}
