package LeetCode.Fair_Candy_Swap;

import java.util.*;

/**
 * 888. Fair Candy Swap
 */
public class Solution {

    /**
     * 哈希+数学
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int amountA = 0; // Alice 有多少个糖果
        int amountB = 0; // Bob 有多少个糖果
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            amountA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            amountB += B[i];
            set.add(B[i]);
        }
        int mean = (amountA+amountB)/2;
        int b;
        for (int i = 0; i < A.length; i++) {
            b = A[i]+(mean-amountA);
            if (set.contains(b))
                return new int[] {A[i],b};
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A = {1,1};
        int[] B = {2,2};

        System.out.println(Arrays.toString(solution.fairCandySwap(A,B)));
    }
}
