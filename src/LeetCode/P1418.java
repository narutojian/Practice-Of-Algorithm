package LeetCode;

import java.util.Arrays;

/**
 * 面试题 01.07.旋转矩阵
 */
public class P1418 {

    /**
     * 找规律 辅助数组
     * 发现(i,j) 在旋转后 变为 (j,n-i-1)
     * @param matrix 原始矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) return;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = Arrays.copyOf(matrix[i],n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n-i-1] = temp[i][j];
            }
        }
    }

    /**
     * 找规律 优化空间
     * @param matrix 原始矩阵
     */
    public void rotate_Solution2(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) return;
        int temp,row,column;
        // n 为奇数
        if ((n & 1) == 1) {
            row = (n-1)/2;
            column = (n+1)/2;
        }
        else row = column = n/2;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
