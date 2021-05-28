package LeetCode.Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class Solution {

    /**
     * 模拟
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int res = 0;
        int start = 0;
        while (start < s.length()) {
            String temp = null;
            if (start+2 <= s.length())
                temp = s.substring(start,start+2);
            Integer tempValue = map.get(temp);
            if (tempValue != null) {
                res += tempValue;
                start += 2;
            }
            else {
                res += map.get(s.substring(start,start+1));
                start++;
            }
        }

        return res;
    }
}
