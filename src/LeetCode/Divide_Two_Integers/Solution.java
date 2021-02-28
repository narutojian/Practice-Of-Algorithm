package LeetCode.Divide_Two_Integers;

/**
 * 29. Divide Two Integers
 */
public class Solution {

    /**
     * 二分查找
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 溢出判断
        if (divisor == 0)
            return -1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (Math.abs(divisor) == 1) {
            return divisor == -1 ? -dividend : dividend;
        }
        // 都转为负数
        if (dividend > 0) {
            dividend = -dividend;
            divisor = -divisor;
        }
        boolean flag = Integer.signum(dividend) == Integer.signum(divisor);// 确定结果符号
        int newDivisor = divisor < 0 ? divisor : -divisor;
        int divisorTemp = newDivisor;
        int res = 0;
        int curRes = 1;
        while (divisorTemp >= dividend) {
            int diff = dividend-divisorTemp;
            if (diff > divisorTemp) {
                res += curRes;
                curRes = 1;
                divisorTemp = newDivisor;
                dividend = diff;
            }
            else if (diff <= divisorTemp) {
                curRes += curRes;
                divisorTemp += divisorTemp;
            }
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int dividend = 10;
//        int divisor = 3;

        int dividend = 2;
        int divisor = 2;

        System.out.println(solution.divide(dividend,divisor));
    }
}
