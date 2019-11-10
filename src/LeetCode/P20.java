package LeetCode;

import java.util.*;

/**
 * 解题思路：
 * 这个题目考察的是栈的使用
 * 将未匹配的字符进栈，匹配到的字符就出栈。
 */
public class P20 {

    public boolean isValid(String s) {
        if (s.equals("")) return true;
        Map<Character,Character> map = new HashMap<>();
        char temp;
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                temp = stack.peekFirst();
                if (map.containsKey(temp) && map.get(temp) == s.charAt(i))
                    stack.removeFirst();
                else stack.addFirst(s.charAt(i));
            }
            else stack.addFirst(s.charAt(i));
        }

        if (stack.isEmpty())
            return true;
        else return false;
    }

    public boolean isValid_Stack(String s) {
        if (s.equals("")) return true;
        Map<Character,Character> map = new HashMap<>();
        char temp,current;
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            /*
            如果是( { [ 这样的字符，只要进栈即可，因为栈里面的字符肯定没有一个与他们匹配
            如果不是上述字符，那就看栈中的第一个字符是否和当前的字符匹配，此时栈可能为空，所以
            要先判断一下栈是否为空，为空的话那这个字符串肯定不是一个有效的字符串了。
             */
            if (map.containsKey(current))
                stack.push(current);
            else {
                if (stack.empty()) return false;
                temp = stack.peek();
                if (map.get(temp) != current)
                    return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Deque<Character> stack = new LinkedList<>();
        stack.addFirst('a');
        stack.addFirst('b');
        stack.addFirst('c');
        System.out.println(stack.peekFirst());
        System.out.println(stack);
    }
}
