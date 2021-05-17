package LeetCode.Perfect_Squares;

/**
 * 279. Perfect Squares
 */
public class Solution {
    /**
     * 暴力递归
     * @param n
     * @return
     */
    public int numSquares(int n) {
        return minNum(n);
    }

    private int minNum(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n / 2 + 1; i++) {
            int cur = i*i;
            if (cur > n)
                break;
            res = Math.min(res,minNum(n-cur)+1);
        }
        return res;
    }
}
