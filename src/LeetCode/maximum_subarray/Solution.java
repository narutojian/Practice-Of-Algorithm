package LeetCode.maximum_subarray;

/**
 * 53. Maximum Subarray
 */
public class Solution {

    /**
     * 动态规划
     * @param nums 数组
     * @return 数组连续子序列的最大和
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1]+nums[i],nums[i]);
            ans = Math.max(nums[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution h = new Solution();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(h.maxSubArray(nums));
    }
}
