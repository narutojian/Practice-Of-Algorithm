package LeetCode.Climbing_Stairs;

/**
 * 70. Climbing Stairs
 */
public class Solution {

    /**
     * dp
     * 滚动数组
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int fir = 1;
        int sec = 2;
        int next;

        for (int i = 3; i <= n; i++) {
            next = fir+sec;
            fir = sec;
            sec = next;
        }
        return sec;
    }
}
