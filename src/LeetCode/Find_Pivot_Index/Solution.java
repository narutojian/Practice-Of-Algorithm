package LeetCode.Find_Pivot_Index;

public class Solution {

    /**
     * 前缀和 后缀和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        int prefixSum = 0;
        int suffixSum = 0;
        for (int i = 0; i < n; i++) {
            suffixSum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            suffixSum -= nums[i];
            if (i != 0) prefixSum += nums[i-1];
            if (suffixSum == prefixSum) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {1,7,3,6,5,6};

        int[] nums = {1,2,3};
        System.out.println(solution.pivotIndex(nums));
    }
}
