package LeetCode.Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    /**
     * 代码优化
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>() {{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length()-1 && value < map.get(s.charAt(i+1)))
                res -= value;
            else res += value;
        }
        return res;
    }
}
