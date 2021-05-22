package LeetCode.Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    /**
     * hash 降低时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < n - 1; i++) {
            int next = target-nums[i];
            Integer index = map.get(next);
            if (index != null && index != i) {
                return new int[]{i,map.get(next)};
            }
        }
        return null;
    }
}
