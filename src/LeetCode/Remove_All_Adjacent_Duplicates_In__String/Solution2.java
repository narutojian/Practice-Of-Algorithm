package LeetCode.Remove_All_Adjacent_Duplicates_In__String;

import java.util.Stack;

public class Solution2 {

    /**
     * 模拟 使用栈
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int n = S.length();
        for (int i = n-1; i > -1; i--) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            }
            else stack.push(S.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}
