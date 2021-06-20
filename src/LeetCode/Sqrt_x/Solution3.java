package LeetCode.Sqrt_x;

public class Solution3 {

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        double x0 = 1;
        double y0 = 1-x;

        while (true) {
            x0 = x0 - (y0/(2*x0));
            y0 = x0*x0-x;
            if (Math.abs(y0) < 1)
                return (int)x0;
        }
    }
}
