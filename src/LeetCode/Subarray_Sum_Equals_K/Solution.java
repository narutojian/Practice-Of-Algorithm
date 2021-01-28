package LeetCode.Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 前缀和+差分+哈希
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);// 如果正好为k的话 不需要寻找前面的区间进行相减
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                res += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,1};
        int k = 2;

//        int[] nums = {1,2,3};
//        int k = 3;

//        int[] nums = {1};
//        int k = 0;

//        int[] nums = {3,2,-3};
//        int k = 2;

        System.out.println(solution.subarraySum(nums,k));
    }
}
