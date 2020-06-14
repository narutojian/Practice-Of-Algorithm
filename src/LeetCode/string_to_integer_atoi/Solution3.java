package LeetCode.string_to_integer_atoi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有限状态自动机
 */
public class Solution3 {

    private Map<String, String[]> map;
    private String curState = "start";
    public Solution3() {
        map = new HashMap<>();
        String[] strings = {"start","signed","number","end"};
        map.put("start", Arrays.copyOf(strings,strings.length));
        strings = new String[] {"end","end","number","end"};
        map.put("signed",Arrays.copyOf(strings,strings.length));
        strings = new String[] {"end","end","number","end"};
        map.put("number",Arrays.copyOf(strings,strings.length));
        strings = new String[] {"end","end","end","end"};
        map.put("end",Arrays.copyOf(strings,strings.length));
    }

    private int getIndex(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (c >= '0' && c <= '9') return 2;
        return 3;
    }

    public int myAtoi(String str) {
        int ans = 0,digit;
        boolean sign = false;
        int maxValue = Integer.MAX_VALUE/10;
        int maxMod = Integer.MAX_VALUE%10;
        for (char i :
                str.toCharArray()) {
            curState = map.get(curState)[getIndex(i)];
            if (curState.equals("end")) break;
            if (curState.equals("start")) continue;
            if (curState.equals("signed")) {
                sign = i == '-';
                maxMod++;
            }
            else {
                digit = i-'0';
                if (ans > maxValue || (ans == maxValue && digit > maxMod)) {
                    return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans*10 + digit;
            }
        }

        return sign ? -ans : ans;
    }
}
