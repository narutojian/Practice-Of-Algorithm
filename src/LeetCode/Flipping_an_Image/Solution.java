package LeetCode.Flipping_an_Image;

/**
 * 832. Flipping an Image
 */
public class Solution {

    /**
     * 模拟遍历
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;

        // flip image
        for (int i = 0; i < n; i++) {
            int left = 0,right= n-1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
        }
        // invert image
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] ^= 1;
            }
        }

        return A;
    }
}
