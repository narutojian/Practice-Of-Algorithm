package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P169 {

    /**
     * 枚举+map记录
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int turns = nums.length/2;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                temp = map.get(nums[i]) + 1;
                if (temp > turns) return nums[i];
                map.put(nums[i],temp);
            }
            else map.put(nums[i],1);
        }
        return nums[0];
    }
}
