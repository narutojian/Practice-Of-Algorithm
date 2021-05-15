package LeetCode.Subarrays_with_K_Different_Integers;

public class Solution2 {

    /**
     * 滑动窗口 贪心
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int n = A.length;
        int[] map = new int[n+1];// map[i]为A中值为i的个数
        int preEnd = -1;
        int curStart = 0;
        int distinct = 0;
        for (;curStart < n-K+1;curStart++) {
            if (curStart != 0) {
                if (map[A[curStart-1]] == 1) {
                    distinct--;
                }
                map[A[curStart-1]]--;
            }
            if (distinct == K) res++;
            for(preEnd += 1;preEnd < n;preEnd++) {
                // 不同的数
                if (map[A[preEnd]] == 0) {
                    distinct++;
                }
                map[A[preEnd]]++;
                // 以curStart为起点,preEnd的窗口中的不同数的个数大于K,则curStart++，preEnd--
                if (distinct > K) break;
                else if (distinct == K) res++;
            }
            // 之后的肯定没有K个不同数字了
            if (distinct < K) break;
            // 把preEnd回退到前面尽可能满足distinct = k的最前的元素位置
            if (preEnd == n) preEnd = n-1;
            while (preEnd > curStart+K) {
                if (map[A[preEnd]] == 1) {
                    distinct--;
                }
                if (distinct < K) {
                    distinct++;
                    break;
                }
                map[A[preEnd]]--;
                preEnd--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] A = {1,2,1,2,3};
        int k = 2;

//        int[] A = {1,2,1,3,4};
//        int k = 3;

//        int[] A = {2,1,2,1,2};
//        int k = 2;

//        int[] A = {2,2,1,2,2,2,1,1};
//        int k = 2;

//        int[] A = {2,1,2,1,1};
//        int k = 3;

        System.out.println(solution2.subarraysWithKDistinct(A,k));
    }
}
