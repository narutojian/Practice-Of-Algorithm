package LeetCode.Rotate_Image;

import java.util.Arrays;

public class Solution2 {

    /**
     * 官方题解中的一种解法
     * 原理也是数学归纳 只不过它又总结了哪些位置需要枚举
     * 所以代码简洁 而且常量开得比较少
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int temp;
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        // test1
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
        // test2
//        int[][] matrix = {
//                {5,1,9,11},
//                {2,4,8,10},
//                {13,3,6,7},
//                {15,14,12,16}
//        };
        // test3
//        int[][] matrix = {
//                {1,2},
//                {3,4}
//        };
        //test4
//        int[][] matrix = {
//                {1}
//        };
        // test5
        int[][] matrix = {
                {5,1,9,11,17,18},
                {2,4,8,10,19,20},
                {13,3,6,7,21,22},
                {15,14,12,16,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36}
        };
        solution2.rotate(matrix);

        for (int[] i :
                matrix) {
            System.out.println(Arrays.toString(i));
        }
    }
}
