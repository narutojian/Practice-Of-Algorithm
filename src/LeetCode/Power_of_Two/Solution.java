package LeetCode.Power_of_Two;

/**
 * 231. Power of Two
 */
public class Solution {

    /**
     * 暴力
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while (i < 31) {
            if (n == (1 << i))
                return true;
            i++;
        }
        return false;
    }
}
