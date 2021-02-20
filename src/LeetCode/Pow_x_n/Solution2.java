package LeetCode.Pow_x_n;

public class Solution2 {

    /**
     * 由递归版本转成迭代版本
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        N = Math.abs(N);

        boolean bit = false;
        double cur = x;
        double res = 1.0;
        while (N > 0) {
            bit = (N%2) == 1;
            if (bit) {
                res *= cur;
            }
            // 左移一位 除2
            N = N >> 1;
            cur *= cur;
        }
        return n < 0 ? 1/res : res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        double x = 2.0;
        int n = 10;

        System.out.println(solution2.myPow(x,n));
    }
}
