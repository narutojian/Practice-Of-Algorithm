package LeetCode.Power_of_Two;

public class Solution2 {

    /**
     * n 为 2的幂
     * 则有 n & (n-1) == 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n&(n-1)) == 0;
    }
}
