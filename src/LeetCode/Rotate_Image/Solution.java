package LeetCode.Rotate_Image;

import java.util.Arrays;

/**
 * 48. Rotate Image
 */
public class Solution {

    /**
     * 数学归纳+空间优化
     * 自己想的 代码可读性不强 不够简洁 如果过久了再来看代码 保证看不懂在写啥
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int temp;
        int baseRow = 0,baseColumn = 0;
        int curRow,curColumn;
        int preRow,preColumn;
        int serial = matrix.length-1;
        int curLevel = matrix.length;
        // 大于1阶 说明还有需要旋转的位置
        while (curLevel > 1) {
            for (int i = 0;i < curLevel-1;++i) {
                curRow = baseRow;
                curColumn = baseColumn+i;
                temp = matrix[curRow][curColumn];
                // 计算出上一个位置的行列号
                preRow = serial - curColumn;
                preColumn = curRow;
                while (preRow != baseRow || preColumn != baseColumn+i) {
                    matrix[curRow][curColumn] = matrix[preRow][preColumn];
                    curRow = preRow;
                    curColumn = preColumn;
                    // 再次更新
                    preRow = serial - curColumn;
                    preColumn = curRow;
                }
                // 如果是最后一个位置了，那就将temp的值赋给它
                matrix[curRow][curColumn] = temp;
            }

            // 旋转一轮后需要修改某些值
            ++baseRow;
            ++baseColumn;
            curLevel -= 2;
        }
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
        solution.rotate(matrix);

        for (int[] i :
                matrix) {
            System.out.println(Arrays.toString(i));
        }
    }
}
