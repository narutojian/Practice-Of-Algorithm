package LeetCode.Merge_k_Sorted_Lists;

import LeetCode.DS.ListNode;

public class Solution2 {

    /**
     * 顺序合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0)
            return null;
        ListNode sentry = new ListNode();
        sentry.next = lists[0];
        for (int i = 1; i < n; i++) {
            ListNode cur = sentry;
            ListNode fir = sentry.next;
            ListNode sec = lists[i];

            while (fir != null && sec != null) {
                if (fir.val > sec.val) {
                    cur.next = sec;
                    sec = sec.next;
                }
                else {
                    cur.next = fir;
                    fir = fir.next;
                }
                cur = cur.next;
            }
            if (fir != null)
                cur.next = fir;
            if (sec != null)
                cur.next = sec;
        }
        return sentry.next;
    }
}
