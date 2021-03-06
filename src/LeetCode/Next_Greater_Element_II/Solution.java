package LeetCode.Next_Greater_Element_II;

import java.util.Arrays;

/**
 * 503. Next Greater Element II
 */
public class Solution {

    /**
     * 想的是动态规划
     * 做出来感觉不是动态规划
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        dp[max] = -1;
        int index = (max-1+n)%n;
        int next;
        while (index != max) {
            next = (index+1)%n;
            while (next != -1 && nums[index] >= nums[next]) {
                next = dp[next];
            }
            dp[index] = next;
            index = (index-1+n)%n;
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;
            dp[i] = nums[dp[i]];
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {1,2,1};

//        int[] nums = {2,2,2};

        int[] nums = {1,2,3,4,3};

        int[] res = solution.nextGreaterElements(nums);

        System.out.println(Arrays.toString(res));
    }
}
