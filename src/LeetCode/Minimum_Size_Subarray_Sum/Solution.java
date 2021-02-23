package LeetCode.Minimum_Size_Subarray_Sum;

/**
 * 209. Minimum Size Subarray Sum
 */
public class Solution {

    /**
     * 前缀和+二分查找
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // 前缀和
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }

        int res = Integer.MAX_VALUE;
        int start,end = 0;

        for (;end < n;end++) {
            if (prefix[end] < target)
                continue;
            int curTarget = prefix[end]-target;
            int left = 0;
            int right = end;
            int mid;
            while (left <= right) {
                mid = left+(right-left)/2;
                if (prefix[mid] == curTarget) {
                    right = mid-1;
                }
                else if (prefix[mid] < curTarget) {
                    left = mid+1;
                }
                else if (prefix[mid] > curTarget) {
                    right = mid-1;
                }
            }
            // left的取值范围为[0,end+1]
            if (left == end+1) {
                start = end;
            }
            else if (left == 0) {
                start = 0;
            }
            else start = prefix[left] == curTarget ? left+1 : left;

            res = Math.min(res,end-start+1);
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

//        int target = 15;
//        int[] nums = {1,2,3,4,5};

        int target = 4;
        int[] nums = {4,4,1};

        System.out.println(solution.minSubArrayLen(target,nums));
    }
}
