package LeetCode.Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    /**
     * 模拟 优化
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
        int cnt = 0;
        while (cnt < s.length()) {
            if (cnt == s.length()-1) {
                res += map.get(s.charAt(cnt));
            }
            else {
                int fir = map.get(s.charAt(cnt));
                int sec = map.get(s.charAt(cnt+1));
                if (fir < sec) {
                    res += sec-fir;
                    cnt++;
                }
                else res += fir;
            }
            cnt++;
        }
        return res;
    }
}
