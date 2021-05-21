package LeetCode.Two_Sum;

/**
 * 1. Two Sum
 */
public class Solution {

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            int sec = target-nums[i];
            for (int j = i+1; j < n; j++) {
                if (sec == nums[j])
                    return new int[]{i,j};
            }
        }
        return null;
    }
}
