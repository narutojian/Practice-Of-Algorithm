package LeetCode.Subarrays_with_K_Different_Integers;

import java.util.HashSet;
import java.util.Set;

/**
 * 992. Subarrays with K Different Integers
 */
public class Solution {

    /**
     * 暴力枚举 超时 O(n^2)
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int res = 0;// 结果
        for (int i = 0; i < n-K+1; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(A[j]);
                if (set.size() == K) {
                    res++;
                }
                else if (set.size() > K) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A = {1,2,1,2,3};
        int k = 2;

        System.out.println(solution.subarraysWithKDistinct(A,k));
    }
}
