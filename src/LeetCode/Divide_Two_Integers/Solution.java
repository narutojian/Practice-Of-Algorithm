package LeetCode.Divide_Two_Integers;

/**
 * 29. Divide Two Integers
 */
public class Solution {

    private int minVal = Integer.MIN_VALUE >> 1;
    /**
     * 数学 递归
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 溢出
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        // 保存符号
        boolean sign = Integer.signum(dividend) == Integer.signum(divisor);
        // 转为负数计算
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int res = getRes(dividend,divisor);
        return sign ? res : -res;
    }

    /**
     * 定义 对于给定的被除数和除数 得到向下取整的商 且只能使用加法
     * @param dividend 被除数（负数）
     * @param divisor 除数（负数）
     * @return 得到向下取整的商
     */
    private int getRes(int dividend,int divisor) {
        if (dividend == 0 || divisor < dividend)
            return 0;
        // 特判 如果小于最小值的一半 说明值最多为1
        if (divisor < minVal)
            return 1;
        int res = 0;
        int origin = divisor;
        int prevDivisor = 0;
        while (divisor >= minVal && divisor >= dividend) {
            prevDivisor = divisor;
            if (res == 0) {
                res = 1;
            }
            else res += res;
            divisor += divisor;
        }

        res += getRes(dividend-prevDivisor,origin);
        return res;
    }
}
