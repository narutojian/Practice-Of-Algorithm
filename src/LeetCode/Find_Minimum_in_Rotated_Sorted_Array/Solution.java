package LeetCode.Find_Minimum_in_Rotated_Sorted_Array;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class Solution {

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        int left = 0;
        int right = n-1;
        int mid;
        while (left <= right) {
            mid = left+(right-left)/2;
            if (nums[left] <= nums[mid]) {
                res = Math.min(res,nums[left]);
                left = mid+1;
            }
            else if (nums[mid] < nums[right]) {
                res = Math.min(res,nums[mid]);
                right = mid-1;
            }
        }

        return res;
    }
}
