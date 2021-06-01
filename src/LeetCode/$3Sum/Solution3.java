package LeetCode.$3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int left = i+1;
            int right = n-1;

            while (left < right) {
                if (left != i+1 && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                if (right != n-1 && nums[right] == nums[right+1]) {
                    right--;
                    continue;
                }
                int sum = nums[left]+nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else right--;
            }
        }
        return res;
    }
}
