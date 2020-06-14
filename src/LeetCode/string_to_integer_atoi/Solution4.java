package LeetCode.string_to_integer_atoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class Solution4 {

    public int myAtoi(String str) {
        int ans = 0;
        str = str.trim();
//        String regex = "^\\s*(\\+|-)?\\d+";
        String regex = "^[+-]?\\d+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group();
            try {
                ans = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                ans = str.charAt(0) == '-'? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution4 h = new Solution4();

//        String str = "words and 987";
        String str = " -42";
        System.out.println(h.myAtoi(str));
    }
}
