package LeetCode.Remove_Duplicates_from_Sorted_Array;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class Solution {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int slow = 1;
        int fast = 1;

        while (fast < n) {
            if (nums[slow-1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
