package LeetCode.Merge_k_Sorted_Lists;

import LeetCode.DS.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
public class Solution {

    /**
     * 优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sentry = new ListNode();
        ListNode track = sentry;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : -1;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.remove();
            if (cur.next != null)
                queue.add(cur.next);
            cur.next = null;
            track.next = cur;
            track = track.next;
        }
        return sentry.next;
    }
}
