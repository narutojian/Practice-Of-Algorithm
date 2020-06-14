package LeetCode;

public class P70 {
    /**
     * 思路完全是归纳总结的方法
     * 用数学的方式列出n为1，2，3等的结果
     * 发现跟斐波那契数列的规律是一样的
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;
        int next = 0;

        while (n-2 > 0) {
            next = first+second;
            first = second;
            second = next;
            n--;
        }
        return next;
    }
}
