package LeetCode.Fibonacci_Number;

/**
 * 509. Fibonacci Number
 */
public class Solution {

    /**
     * 动态规划
     * 官方题解中其他的解法也挺好
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int first = 0;
        int second = 1;
        int next = 0;
        int i = 1;
        while (i < n) {
            next = first+second;
            first = second;
            second = next;
            i++;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 30;
        System.out.println(solution.fib(n));
    }
}
