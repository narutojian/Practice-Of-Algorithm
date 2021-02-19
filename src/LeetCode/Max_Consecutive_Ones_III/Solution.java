package LeetCode.Max_Consecutive_Ones_III;

/**
 * 1004. Max Consecutive Ones III
 */
public class Solution {

    /**
     * 双指针
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int n = A.length;
        int left = 0;
        int right = 0;

        for (;right < n;right++) {
            if (A[right] == 0) {
                if (K == 0) {
                    res = Math.max(res,right-left);
                    // 去掉前面的一个0
                    while (A[left] == 1) {
                        left++;
                    }
                    left++;
                }
                else K--;
            }
        }
        res = Math.max(res,right-left);
        return res;
    }
}
