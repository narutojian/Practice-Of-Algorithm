package LeetCode.Number_of_1_Bits;

public class Solution2 {

    /**
     * 位运算 优化
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        int cur = 1;
        int i = 0;
        while (i < 32) {
            if ((n & cur) == cur)
                res++;
            cur <<= 1;
            i++;
        }

        return res;
    }
}
