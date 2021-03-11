package LeetCode.Palindrome_Linked_List;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 */
public class Solution {

    /**
     * 栈
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }
}
