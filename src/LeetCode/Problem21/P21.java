package LeetCode.Problem21;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：
 * 1. 一开始想到的正解是 用队列的思想，把每个节点都放入队列中；
 * 然后比较两个队列的首元素的值的大小，小的就放到我创建的链表后面。
 * 2. 看了别人的解法，发现原来还可以递归求解，emm瞬间感觉我好蠢啊。
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null) return l1;

        Queue<ListNode> queue1 = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        ListNode head = new ListNode(0);
        ListNode ans = head;
        while (l1 != null) {
            queue1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
             queue2.add(l2);
             l2 = l2.next;
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek().val <= queue2.peek().val)
                head.next = queue1.poll();
            else head.next = queue2.poll();
            head = head.next;
        }

        while (!queue1.isEmpty()) {
            head.next = queue1.poll();
            head = head.next;
        }
        while (!queue2.isEmpty()) {
            head.next = queue2.poll();
            head = head.next;
        }
        return ans.next;
    }
}
