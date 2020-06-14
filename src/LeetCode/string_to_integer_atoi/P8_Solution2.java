package LeetCode.string_to_integer_atoi;

import java.util.LinkedList;
import java.util.Queue;

public class P8_Solution2 {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        Queue<Character> queue = new LinkedList<>();
        boolean sign = false; // 默认符号为正号
        int temp,ans = 0;
        char[] chars = str.toCharArray();

        int index = 0;
        if (chars[index] != '+' && chars[index] != '-' && (chars[index] - '0' < 0 || chars[index] - '0' > 9)) return 0;
        else if (chars[index] == '+' || chars[index] == '-') {
            sign = chars[index] == '+' ? false : true;
            index++;
        }

        for (;index < chars.length && queue.size() <= 11;index++) {
            temp = chars[index] - '0';
            if (temp < 0 || temp > 9) break;
            // 防止是 0000012345这种形式的 除去掉0
            if (queue.size() == 0 && temp == 0) continue;
            queue.add(chars[index]);
        }

        // 判断是否超出整数的范围
        if (queue.size() == 11 || (queue.size() == 10 && queue.peek() > '2')) return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int mutiple = (int) Math.pow(10,queue.size()-1);
        while (!queue.isEmpty()) {
            int cur = (queue.remove() - '0')*mutiple;
            if (Integer.MIN_VALUE - ans + cur > 0) return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans -= cur;
            mutiple /= 10;
        }
        if (ans == Integer.MIN_VALUE && !sign) return Integer.MAX_VALUE;
        return sign ? ans : -ans;
    }

    public static void main(String[] args) {
        P8_Solution2 h = new P8_Solution2();
        String str = "42";
        System.out.println(h.myAtoi(str));
    }
}
