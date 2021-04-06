package LeetCode.Remove_Duplicates_from_Sorted_Array_II;

public class Solution2 {

    /**
     * 双指针 快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;
        int slow = 2;
        int fast = 2;
        while (fast < n) {
            if (nums[slow-2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
