package LeetCode.Search_a_2D_Matrix_II;

/**
 * 240. Search a 2D Matrix II
 */
public class Solution {

    /**
     * 二分查找一行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;
            int mid;

            while (left < right) {
                mid = left+(right-left)/2;
                if (matrix[i][mid] == target) {
                    return true;
                }
                else if (matrix[i][mid] < target) {
                    left = mid+1;
                }
                else if (matrix[i][mid] > target) {
                    right = mid;
                }
            }
            if (left != n && matrix[i][left] == target)
                return true;
        }

        return false;
    }
}
