package LeetCode.Binary_Search;

/**
 * 704. Binary Search
 */
public class Solution {

    /**
     * 二分查找 搜索区间[0,nums.length-1]
     * 查找指定数的模板
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid+1;
            }
            else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        return -1;
    }
}
