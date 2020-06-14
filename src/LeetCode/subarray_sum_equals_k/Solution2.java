package LeetCode.subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    /**
     * 前缀和+哈希优化
     * @param nums 数组
     * @param k 目标值
     * @return 返回子数组和为k的个数
     */
    public int subarraySum(int[] nums, int k) {
        int pre = 0,ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
//            可以用map.put(pre,map.getOrDefault(pre,0)+1); 替代下面的添加操作
//            将pre放入map中，判断是否已经存在pre
//            if (map.containsKey(pre)) {
//                map.put(pre,map.get(pre)+1);
//            }
//            else {
//                map.put(pre,1);
//            }
//            使用map.put(0,1) 就可以替代下面这个判断
//            如果pre[i]以i结尾的数组之和的值为k，则ans++
//            if (pre == k) {
//                ans++;
//            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        int[] nums = {1,1,1};
        int k = 2;

        System.out.println(h.subarraySum(nums,k));
    }
}