package LeetCode.Pow_x_n;

/**
 * 50. Pow(x, n)
 */
public class Solution {

    /**
     * 递归进行 二分 计算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;

        return N < 0 ? 1/binaryMultiple(x,-N) : binaryMultiple(x,N);
    }

    private double binaryMultiple(double x,long n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = binaryMultiple(x,n/2);
        return n%2 == 1 ? temp*temp*x : temp*temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        double x = 2.00000;
        int n = 10;

        System.out.println(solution.myPow(x,n));
    }
}
