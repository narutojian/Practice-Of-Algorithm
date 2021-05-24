package LeetCode.Reverse_Integer;

/**
 * 7. Reverse Integer
 */
public class Solution {

    /**
     * 数学
     * @param x
     * @return
     */
    public int reverse(int x) {
        int min = Integer.MIN_VALUE/10;
        int minNum = Math.abs(Integer.MIN_VALUE%10);
        int sign = Integer.signum(x);// 判断符号
        int res = 0;// 都按照负数来处理
        while (x != 0) {
            int num = Math.abs(x%10);
            if (res < min || (res == min && minNum < num)) // 越界
                return 0;
            res = res*10 - num;
            x /= 10;
        }
        if (sign == 1 && res == Integer.MIN_VALUE) // 正数越界
            return 0;
        return sign == 1 ? -res : res;
    }
}
