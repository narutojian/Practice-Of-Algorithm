package LeetCode.Number_of_1_Bits;

public class Solution5 {

    /**
     * 位运算 jdk方法
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
