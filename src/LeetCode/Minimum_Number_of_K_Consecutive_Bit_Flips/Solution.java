package LeetCode.Minimum_Number_of_K_Consecutive_Bit_Flips;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 */
public class Solution {

    /**
     * 暴力模拟
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int res = -1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                flag = false;
                if (i+K > n) {
                    res = -1;
                    break;
                }
                for (int j = i; j < i+K; j++) {
                    A[j] = A[j]^1;
                }
                if (res == -1) {
                    res = 1;
                }
                else res++;
            }
        }
        if (flag) return 0;
        return res;
    }
}
