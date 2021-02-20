package LeetCode.Degree_of_an_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. Degree of an Array
 */
public class Solution {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> cnt = new HashMap<>();
        int maxFre = 0;
        for (int i = 0; i < n; i++) {
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
            maxFre = Math.max(maxFre,cnt.get(nums[i]));
        }
        List<Integer> candidates = new ArrayList<>();
        for (Integer key : cnt.keySet()) {
            if (cnt.get(key) == maxFre) {
                candidates.add(key);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int candidate: candidates) {
            int left = 0;
            int right = n-1;

            while (nums[left] != candidate) {
                left++;
            }
            while (nums[right] != candidate) {
                right--;
            }
            res = Math.min(res,right-left+1);
        }
        return res;
    }
}
