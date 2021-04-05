package LeetCode.Rabbits_in_Forest;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest
 */
public class Solution {

    /**
     * 贪心 数学
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int key : answers) {
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int num = key+1;
            res += (map.get(key)/num)*num;
            if (map.get(key) % num != 0)
                res += num;
        }

        return res;
    }
}
