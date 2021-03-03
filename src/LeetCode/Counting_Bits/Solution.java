package LeetCode.Counting_Bits;

import java.util.Arrays;

/**
 * 338. Counting Bits
 */
public class Solution {

    /**
     * 暴力枚举
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int cur;
        for (int i = 0; i < res.length; i++) {
            cur = i;
            while (cur > 0) {
                res[i] += cur & 1;
                cur >>= 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int num = 5;

        System.out.println(Arrays.toString(solution.countBits(num)));
    }
}
