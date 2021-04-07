package LeetCode.Number_of_1_Bits;

public class Solution4 {

    /**
     * 位运算 >>> 为java中的无符号右移
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            if ((n&1) == 1)
                res++;
            n >>>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        int n = -2147483648;

        System.out.println(solution4.hammingWeight(n));
    }
}
