package LeetCode.Number_of_1_Bits;

/**
 * 191. Number of 1 Bits
 */
public class Solution {

    /**
     * 位运算
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        int i = 0;
        while (i < 32) {
            int cur = 1 << i;
            if ((n & cur) == cur)
                res++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = -1;

        System.out.println(solution.hammingWeight(n));
    }
}
