package LeetCode.Longest_Continuou_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

public class Solution {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 1;
        int left = 0;
        int right = 1;

        for (;right < n;right++) {
            boolean flag = true;
            int i = right-1;
            for (; i > left-1; i--) {
                if (Math.abs(nums[right]-nums[i]) > limit) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                res = Math.max(res,right-left);
                left = i+1;
            }
        }
        res = Math.max(res,right-left);

        return res;
    }
}
