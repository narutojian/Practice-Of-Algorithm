package LeetCode.Reshape_the_Matrix;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 */
public class Solution {

    /**
     * 二维数组映射一维数组
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length;
        int y = nums[0].length;
        if (x*y != r*c) return nums;

        int[][] res = new int[r][c];
        int index,oriRow,oriCol;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                index = i*c+j;
                oriRow = index/y;
                oriCol = index%y;
                res[i][j] = nums[oriRow][oriCol];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] nums = {
//                {1,2},
//                {3,4}
//        };
//        int r = 1;
//        int c = 4;

        int[][] nums = {
                {1,2,3,4}
        };
        int r = 2;
        int c = 2;

        int[][] res = solution.matrixReshape(nums,r,c);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}
