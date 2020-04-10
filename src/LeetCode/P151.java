package LeetCode;

import java.util.Stack;

public class P151 {

    /**
     * 单词压栈 依次弹出即可反转单词
     * @param s 给定的字符串
     * @return 反转的字符串
     */
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int start = 0,end = 0;
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (end - start > 0) {
                    stack.push(s.substring(start,end));
                }
                start = end = i+1;
            }
            else end++;
        }
        if (end - start > 0) stack.push(s.substring(start,end));
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (stack.size() != 1) ans.append(" ");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        P151 h = new P151();
        String s = "the sky is blue";
        System.out.println(h.reverseWords(s));
    }
}
