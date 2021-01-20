package LeetCode.Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 */
public class Solution {
    /**
     * 排序 数学
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {1,2,3,4};

        int[] nums = {-1,-2,-3,-4};

//        int[] nums = {-1,-2,-3};

//        int[] nums = {1,2,3};

//        int[] nums = {7,1,2,8,4,2};

//        int[] nums = {7,1,2,6,3,4,5};

        System.out.println(solution.maximumProduct(nums));
    }
}
