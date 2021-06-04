package LeetCode.Remove_Nth_Node_From_End_of_List;

import LeetCode.DS.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class Solution {

    /**
     * 找到被删节点的正序位置，删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode();
        sentry.next = head;
        int len = 0;
        // 确定链表长度
        ListNode prev = sentry;
        while (prev.next != null) {
            len++;
            prev = prev.next;
        }
        int pos = len-n;
        prev = sentry;
        // 确定被删节点的前驱节点
        while (pos > 0) {
            prev = prev.next;
            pos--;
        }
        ListNode temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
        return sentry.next;
    }
}
