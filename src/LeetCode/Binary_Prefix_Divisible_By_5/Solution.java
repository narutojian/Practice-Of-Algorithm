package LeetCode.Binary_Prefix_Divisible_By_5;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 */
public class Solution {
    /**
     * 模拟 模运算
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();

        int val = 0;// 存储当前二进制的值(十进制表示)
        for (int i = 0; i < A.length; i++) {
            val = (val<<1)+A[i];
            // 防止大数溢出
            val %= 5;
            if (val == 0) {
                res.add(true);
            }
            else res.add(false);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] A = {0,1,1};

        int[] A = {1,1,1};

//        int[] A = {0,1,1,1,1,1};

//        int[] A = {1,1,1,0,1};
        System.out.println(solution.prefixesDivBy5(A));
    }
}
