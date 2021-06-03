package LeetCode.$4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 */
public class Solution {

    /**
     * 排序+双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < n; j++) {
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                int targetSum = target-(nums[i]+nums[j]);
                int left = j+1;
                int right = n-1;

                while (left < right) {
                    if (left != j+1 && nums[left] == nums[left-1]) {
                        left++;
                        continue;
                    }
                    if (right != n-1 && nums[right] == nums[right+1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[left]+nums[right];
                    if (sum == targetSum) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    else if (sum < targetSum) {
                        left++;
                    }
                    else right--;
                }
            }
        }
        return res;
    }
}
