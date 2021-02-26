package LeetCode.Search_in_Rotated_Sorted_Array_II;

/**
 * 81. Search in Rotated Sorted Array II
 */
public class Solution {

    /**
     * 二分查找 去除重复数字
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid;

        while (left <= right) {
            mid = left+(right-left)/2;
            // 去掉重复的数字
            while (left != mid && nums[left] == nums[mid]) {
                left++;
            }
            while (right != mid && nums[right] == nums[mid]) {
                right--;
            }

            if (nums[mid] == target)
                return true;
            else if (nums[mid] >= nums[left]) {
                // 左边递增
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                }
                else left = mid+1;
            }
            else if (nums[mid] < nums[right]) {
                // 右边递增
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                }
                else right = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,0,1,1,1};
        int target = 0;

        System.out.println(solution.search(nums,target));
    }
}
