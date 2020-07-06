package LeetCode.search_insert_position;

/**
 * 35. Search Insert Position
 */
public class Solution {

    /**
     * 二分查找
     * @param nums 数组序列
     * @param target 目标元素
     * @return 插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        int mid;
        // nums中最大的元素小于target 所以target插入到nums的尾部
        if (nums[high] < target) {
            return high+1;
        }
        while (low < high) {
            mid = (low+high) >>> 1;
            // 小于target的 那么(low,mid)的区间里肯定没有target这个元素
            if (nums[mid] < target) {
                // 下一轮的区间变为 (mid+1,high)
                low = mid+1;
            }
            else {
                // 下一轮的区间为 (low,mid)，该区间里必定有target元素
                high = mid;
            }
        }
        // 最后，low == high
        return low;
    }
}
