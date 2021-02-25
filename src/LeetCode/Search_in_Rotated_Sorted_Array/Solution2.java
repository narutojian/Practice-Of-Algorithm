package LeetCode.Search_in_Rotated_Sorted_Array;

public class Solution2 {

    /**
     * 二分查找 时间复杂度O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid;

        while (left <= right) {
            mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] >= nums[left]) {
                // 左边有序
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                }
                else left = mid+1;
            }
            else if (nums[mid] < nums[right]) {
                // 右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid+1;
                }
                else right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;

        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;

        System.out.println(solution2.search(nums,target));
    }
}
