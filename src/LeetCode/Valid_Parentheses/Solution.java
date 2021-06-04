package LeetCode.Valid_Parentheses;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class Solution {

    /**
     * 栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            else if (cur == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
            else if (cur == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
            else stack.push(cur);
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
