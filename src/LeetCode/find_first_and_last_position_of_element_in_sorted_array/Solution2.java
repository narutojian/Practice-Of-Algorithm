package LeetCode.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class Solution2 {

    /**
     * 二分查找 分别查找target的左侧区间和右侧区间
     * 二分查找模板 需在理解下记忆
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1,-1};
        int[] res = new int[2];

        int left = 0;
        int right = n;
        int mid;
        // 左侧区间搜索 区间为[left,right)
        while (left < right) {
            mid = left+(right-left)/2;
            if (nums[mid] == target) {
                right = mid;// 区间为 [left,mid)
            }
            else if (nums[mid] < target) {
                left = mid+1;// 区间为 [mid+1,right)
            }
            else if (nums[mid] > target) {
                right = mid;// 区间为 [left,mid)
            }
        }
        // 左侧区间有n个数 说明此时target大于所有的数
        if (left == n)
            res[0] = -1;
        else res[0] = nums[left] == target ? left : -1;

        // 右侧区间搜索 区间为[left,right)
        left = 0;
        right = n;
        while (left < right) {
            mid = left+(right-left)/2;
            // 这里保证了 如果left值是有效的 那么最后nums[left]必定大于target
            if (nums[mid] == target) {
                left = mid+1;// 区间为 [mid+1,right)
            }
            else if (nums[mid] < target) {
                left = mid+1;// 区间为 [mid+1,right)
            }
            else if (nums[mid] > target) {
                right = mid;// 区间为 [left,mid)
            }
        }
        // 右侧区间的第一个数为nums数组的第一个数 说明target小于所有的数
        if (left == 0)
            res[1] = -1;
        else res[1] = nums[left-1] == target ? left-1 : -1;

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        int[] nums = {2,2};
//        int target = 3;

//        int[] nums = {2,2,3};
//        int target = 3;

//        int[] nums = {2,2};
//        int target = 2;

        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        System.out.println(Arrays.toString(solution2.searchRange(nums,target)));
    }
}
