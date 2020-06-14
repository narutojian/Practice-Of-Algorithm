package LeetCode.problem21;

public class P21_Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode index = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                index.next = l1;
                l1 = l1.next;
            }
            else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }

        if (l1 != null) index.next = l1;
        if (l2 != null) index.next = l2;
        return ans.next;
    }
}
