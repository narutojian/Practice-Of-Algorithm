package LeetCode.$3Sum_Closest;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */
public class Solution {

    /**
     * 排序+双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int gap = Math.abs(target-res);
            int targetSum = target-nums[i];
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int sum = nums[left]+nums[right];
                if (sum == targetSum)
                    return target;
                else if (sum < targetSum) {
                    left++;
                }
                else right--;
                if (Math.abs(targetSum-sum) < gap) {
                    gap = Math.abs(targetSum-sum);
                    res = nums[i]+sum;
                }
            }
        }
        return res;
    }
}
