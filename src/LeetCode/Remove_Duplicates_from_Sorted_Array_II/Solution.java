package LeetCode.Remove_Duplicates_from_Sorted_Array_II;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class Solution {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 0;
        int cnt = 1;
        int preVal = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != preVal) {
                cnt = 1;
                preVal = nums[i];
                // 更新
                nums[++p] = nums[i];
            }
            else {
                cnt++;
                if (cnt <= 2){
                    // 更新
                    nums[++p] = nums[i];
                }
            }
        }
        return p+1;
    }
}
