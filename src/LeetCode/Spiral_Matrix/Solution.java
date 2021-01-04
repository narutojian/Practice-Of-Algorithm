package LeetCode.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class Solution {

    /**
     * 模拟螺旋输出矩阵
     * 时间复杂度 O(mn),空间复杂段O(1)
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;// 行
        int n = matrix[0].length; // 列
        int round = Math.min(m,n)%2 == 1 ? Math.min(m,n)/2+1 : Math.min(m,n)/2; // 要模拟几圈
        int startRow,startColumn;// 起始点 当前圈的左上角的点

        for (int i = 0; i < round; i++) {
            startRow = i;
            startColumn = i;

            // 先行
            for (;startColumn < n-i;++startColumn)
                ans.add(matrix[startRow][startColumn]);
            --startColumn;
            ++startRow;
            // 再列
            if (startRow == m-i) break;
            for (;startRow < m-i;++startRow)
                ans.add(matrix[startRow][startColumn]);
            --startRow;
            --startColumn;
            // 再行
            if (startColumn == i-1) break;
            for (;startColumn > i-1;--startColumn)
                ans.add(matrix[startRow][startColumn]);
            ++startColumn;
            --startRow;
            // 再列
            for (;startRow > i;--startRow)
                ans.add(matrix[startRow][startColumn]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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
//        int[][] matrix = {
//                {2,5,8},
//                {4,0,-1}
//        };
        // test5
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        List<Integer> ans = solution.spiralOrder(matrix);

        System.out.println(ans);
    }
}
