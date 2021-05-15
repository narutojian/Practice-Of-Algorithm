package LeetCode.Longest_Continuou_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

public class Solution2 {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 1;
        int left = 0;
        int right = 1;
        int minVal = nums[0];
        int maxVal = nums[0];
        int minValIndex = 0;
        int maxValIndex = 0;

        for (;right < n;right++) {
            if (minVal >= nums[right]) {
                minVal = nums[right];
                minValIndex = right;
            }
            if (maxVal <= nums[right]) {
                maxVal = nums[right];
                maxValIndex = right;
            }

            if (maxVal - minVal > limit) {
                res = Math.max(res,right-left);
                if (minVal == nums[right]) {
                    left = maxValIndex+1;
                }
                else if (maxVal == nums[right]) {
                    left = minValIndex+1;
                }
            }
        }
        res = Math.max(res,right-left);
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] nums = {8,2,4,7};
        int limit = 4;

        System.out.println(solution2.longestSubarray(nums,limit));
    }
}
