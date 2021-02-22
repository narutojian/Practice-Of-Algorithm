package LeetCode.Search_a_2D_Matrix;

/**
 * 74. Search a 2D Matrix
 */
public class Solution {

    /**
     * 二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 搜索区间 [left,right)
        int left = 0;
        int right = m*n;
        int mid;
        int x,y;
        while (left < right) {
            mid = left+(right-left)/2;
            x = mid/n;
            y = mid%n;
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] < target) {
                left = mid+1;
            }
            else if (matrix[x][y] > target) {
                // 因为有边界是开区间，所以此处right = mid 即下次区间为[left,mid)
                right = mid;
            }
        }
        if (left != m*n && matrix[left/n][left%n] == target)
            return true;
        return false;
    }
}
