package LeetCode.Add_Two_Numbers;

import LeetCode.DS.ListNode;

/**
 * 2. Add Two Numbers
 */
public class Solution {

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        mergeListNode(res,l1,l2,0);
        return res.next;
    }

    private void mergeListNode(ListNode cur,ListNode l1,ListNode l2,int add) {
        if (l1 == null && l2 == null && add == 0)
            return;
        int first = 0;
        int sec = 0;
        if (l1 != null) {
            first = l1.val;
        }
        if (l2 != null) {
            sec = l2.val;
        }
        int curVal = first+sec+add;
        ListNode node = new ListNode(curVal%10);
        cur.next = node;
        mergeListNode(cur.next,l1 == null? null : l1.next,l2 == null ? null : l2.next,curVal/10);
    }
}
