package LeetCode.Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 */
public class Solution {

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n-1;
        int mid;
        while (left < right) {
            mid = left+(right-left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] >nums[right]) {
                left = mid+1;
            }
            else right--;
        }

        return nums[left];
    }
}
