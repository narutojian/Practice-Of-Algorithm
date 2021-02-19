package LeetCode.Max_Consecutive_Ones_III;

public class Solution2 {

    /**
     * 前缀和 二分查找
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int n = A.length;
        // 前缀和
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] ^= 1;
            if (i == 0) {
                prefix[i] = A[i];
            }
            else prefix[i] = A[i]+prefix[i-1];
        }

        int start = 0,end = Math.min(n-1,K+1);

        for (;end < n;end++) {
            // 二分查找
            // 寻找满足 prefix[end] - prefix[start-1] <= k 的start
            // 也就是 prefix[start-1] >= prefix[end] - K 要求start尽可能的小
            // 即在区间[start,end]上至多有K个0
            // 二分查找区间[left,right) 寻找target的左侧区间上的最后一个元素的索引
            int target = prefix[end] - K;
            int left = 0;
            int right = end+1;
            int mid;
            while (left < right) {
                mid = left+(right-left)/2;
                if (prefix[mid] == target) {
                    right = mid;
                }
                else if (prefix[mid] < target) {
                    left = mid+1;
                }
                else if (prefix[mid] > target) {
                    right = mid;
                }
            }
            start = left == 0 ? 0 : left+1;
            res = Math.max(res,end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;

//        int[] A = {0,0,0,1};
//        int K = 4;

        System.out.println(solution2.longestOnes(A,K));
    }
}
