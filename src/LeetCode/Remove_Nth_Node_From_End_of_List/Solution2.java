package LeetCode.Remove_Nth_Node_From_End_of_List;

import LeetCode.DS.ListNode;

public class Solution2 {

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode();
        sentry.next = head;

        ListNode fast = sentry;// 快指针
        ListNode slow = sentry;// 慢指针

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;

        return sentry.next;
    }
}
