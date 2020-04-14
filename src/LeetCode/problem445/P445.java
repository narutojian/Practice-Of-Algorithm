package LeetCode.problem445;

import java.util.Stack;

public class P445 {

    /**
     * 用栈逆序保存链表的值
     * @param l1 链表一
     * @param l2 链表二
     * @return 两数相加之和 链表形式
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;

        Stack<Integer> stack1 = getDigit(l1);
        Stack<Integer> stack2 = getDigit(l2);

        ListNode ans = new ListNode(0);
        int one,two,digit,carry = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (stack1.empty()) one = 0;
            else one = stack1.pop();
            if (stack2.empty()) two = 0;
            else two = stack2.pop();

            digit = (one+two+carry)%10;
            carry = (one+two+carry)/10;
            ListNode node = new ListNode(digit);
            node.next = ans.next;
            ans.next = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = ans.next;
            ans.next = node;
        }

        return ans.next;
    }

    private Stack<Integer> getDigit(ListNode node) {
        Stack<Integer> ans = new Stack<>();
        while (node != null) {
            ans.push(node.val);
            node = node.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        P445 h = new P445();

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node_1 = new ListNode(5);
        ListNode node_2 = new ListNode(6);
        ListNode node_3 = new ListNode(4);
        node_1.next = node_2;
        node_2.next = node_3;

        ListNode l1 = node1;
        ListNode l2 = node_1;

        h.addTwoNumbers(l1,l2);
    }
}
