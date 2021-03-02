package LeetCode.Range_Sum_Query_2D_Immutable;

/**
 * 304. Range Sum Query 2D - Immutable
 */
public class NumMatrix {
    int[][] prefix;

    /**
     * 二维前缀和
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        prefix = new int[m][n];
        prefix[0][0] = matrix[0][0];

        // 初始化第一行的前缀和
        for (int i = 1; i < n; i++) {
            prefix[0][i] = prefix[0][i-1]+matrix[0][i];
        }
        // 初始化第一列的前缀和
        for (int i = 1; i < m; i++) {
            prefix[i][0] = prefix[i-1][0]+matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up,left,upLeft;

        up = row1 == 0 ? 0 : prefix[row1-1][col2];
        left = col1 == 0 ? 0 : prefix[row2][col1-1];
        upLeft = (row1 == 0 || col1 == 0) ? 0 : prefix[row1-1][col1-1];

        return prefix[row2][col2]-up-left+upLeft;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
}
