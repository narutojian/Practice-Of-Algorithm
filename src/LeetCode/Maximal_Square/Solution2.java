package LeetCode.Maximal_Square;

public class Solution2 {
    /**
     * dp
     * dp[i][j] 表示以(i,j)为最右节点结尾的最大的正方形的边长
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        int curMaxLen;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                curMaxLen = Math.min(i+1,j+1);
                for (int k = 1; k < curMaxLen + 1; k++) {
                    if (dp[i-1][j] < k-1 ||  dp[i][j-1] < k-1 || dp[i-1][j-1] < k-1)
                        break;
                    dp[i][j] = k;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res*res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        // test1
//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };

        // test2
        char[][] matrix = {
                {'0','1'},
                {'1','0'}
        };

        // test3
//        char[][] matrix = {
//                {'1','1'},
//                {'1','1'}
//        };

        System.out.println(solution2.maximalSquare(matrix));
    }
}
