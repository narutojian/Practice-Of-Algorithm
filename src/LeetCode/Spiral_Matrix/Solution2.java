package LeetCode.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /**
     * 官方题解 解题思路清晰
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        // (top,left) 表示左上角的点
        int top = 0;
        int left = 0;
        // (bottom,right) 表示右下角的点
        int bottom = m-1;
        int right = n-1;

        while (top <= bottom && left <= right) {
            // 向右遍历
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            // 向下遍历
            for (int i = top+1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                // 向左遍历
                for (int i = right-1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                // 向上遍历
                for (int i = bottom-1; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return ans;
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
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };
        // test3
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//                {10,11,12}
//        };
        // test4
        int[][] matrix = {
                {2,5,8},
                {4,0,-1}
        };
        // test5
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        List<Integer> ans = solution2.spiralOrder(matrix);
        System.out.println(ans);
    }
}
