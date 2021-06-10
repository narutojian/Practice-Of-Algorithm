package LeetCode.Swap_Nodes_in_Pairs;

import LeetCode.DS.ListNode;

public class Solution2 {

    /**
     * 递归
     * 定义 两两交换 以head为头节点的链表的节点 并返回新的链表头节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode next = swapPairs(newHead.next);

        head.next = next;
        newHead.next = head;
        return newHead;
    }
}
