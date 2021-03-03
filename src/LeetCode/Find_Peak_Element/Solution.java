package LeetCode.Find_Peak_Element;

/**
 * 162. Find Peak Element
 */
public class Solution {
    /**
     * 暴力枚举 O(n)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[i+1])
                return i;
        }
        return n-1;
    }
}
