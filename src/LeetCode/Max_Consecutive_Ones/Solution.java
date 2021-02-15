package LeetCode.Max_Consecutive_Ones;

/**
 * 485. Max Consecutive Ones
 */
public class Solution {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;
        int start = 0;
        int end = 0;
        for (;end < n;end++) {
            if (nums[end] == 0) {
                res = Math.max(res,end-start);
                start = end+1;
            }
        }
        res = Math.max(res,end-start);
        return res;
    }
}
