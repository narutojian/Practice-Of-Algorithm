package LeetCode.Swap_Nodes_in_Pairs;

import LeetCode.DS.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class Solution {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode sentry = new ListNode();
        sentry.next = head;

        ListNode prev = sentry;
        ListNode fir,sec;
        while (prev.next != null && prev.next.next != null) {
            fir = prev.next;
            sec = fir.next;
            // 交换
            fir.next = sec.next;
            prev.next = sec;
            sec.next = fir;

            prev = fir;
        }
        return sentry.next;
    }
}
