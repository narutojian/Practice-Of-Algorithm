package LeetCode.Sqrt_x;

/**
 * 69. Sqrt(x)
 */
public class Solution {

    /**
     * 暴力枚举
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int maxVal = (int) Math.pow(Integer.MAX_VALUE,0.5);

        for (int i = 0; i <= maxVal; i++) {
            if (i*i > x)
                return i-1;
        }
        return maxVal;
    }
}
