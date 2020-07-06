package LeetCode.find_first_and_last_position_of_element_in_sorted_array;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class Solution {

    /**
     * 二分查找
     * 两个二分查找
     * 一个是找第一个等于target的index的二分查找
     * 一个是找最后一个等于target的index的二分查找
     * @param nums 数组序列
     * @param target 目标值
     * @return 【第一个等于target的index，第二个等于target的index】
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1]) {
            return ans;
        }
        int left = 0,right = nums.length-1;
        int mid;

        // 找第一个等于target的index
        while (left < right) {
            mid = (left+right) >>> 1;
            // 小于target元素的区间一定不存在第一个等于target的元素
            if (nums[mid] < target) {
                // 下一轮区间为[mid+1,right]
                left = mid+1;
            }
            else {
                // 下一轮区间为[left,mid]
                right = mid;
            }
        }
        ans[0] = nums[left] == target ? left : -1;

        left = 0;
        right = nums.length-1;
        // 找最后一个target的index
        while (left < right) {
            // 向上取整，消除死循环
            mid = (left+right+1) >>> 1;
            // 大于target的区间 一定不存在最后一个等于target元素的区间
            if (nums[mid] > target) {
                // 下一轮区间为[left,mid-1]
                right = mid-1;
            }
            else {
                // 下一轮区间为[mid,right]
                left = mid;
            }
        }
        ans[1] = nums[left] == target ? left : -1;
        return ans;
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        for (int i : h.searchRange(nums, target)) {
            System.out.println(i);
        }
    }
}
