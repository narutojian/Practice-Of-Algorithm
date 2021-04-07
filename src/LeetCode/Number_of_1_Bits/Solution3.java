package LeetCode.Number_of_1_Bits;

public class Solution3 {

    /**
     * 位运算 优化
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n &= (n-1);
            res++;
        }
        return res;
    }
}
