package LeetCode.Toeplitz_Matrix;

/**
 * 766. Toeplitz Matrix
 */
public class Solution {

    /**
     * 遍历
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean res = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return res;
    }
}
