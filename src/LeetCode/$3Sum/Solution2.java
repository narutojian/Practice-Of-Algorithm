package LeetCode.$3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    /**
     * 排序+二分查找
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < n; j++) {
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                int target = -(nums[i]+nums[j]);
                if (binarySearch(j+1,n-1,target,nums)) {
                    res.add(Arrays.asList(nums[i],nums[j],target));
                }
            }
        }
        return res;
    }

    private boolean binarySearch(int left,int right,int target,int[] nums) {
        int mid;
        while (left <= right) {
            mid = left+(right-left)/2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
