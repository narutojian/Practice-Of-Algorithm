package LeetCode.Merge_Two_Sorted_Lists;

/**
 * 21. Merge Two Sorted Lists
 */
public class Solution {
    ListNode res = new ListNode(0);

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        mergeLists(res,l1,l2);
        return res.next;
    }

    /**
     * cur 记录结果链表的最末位置
     * @param cur
     * @param l1
     * @param l2
     */
    private void mergeLists(ListNode cur,ListNode l1,ListNode l2) {
        if (l1 == null && l2 == null)
            return;
        if (l1 == null) {
            cur = l2;
            mergeLists(cur,null,null);
        }
        else if (l2 == null) {
            cur = l1;
            mergeLists(cur,null,null);
        }
        else {
            if (l1.val > l2.val) {
                cur.next = l2;
                mergeLists(cur.next,l1,l2.next);
            }
            else {
                cur.next = l1;
                mergeLists(cur.next,l1.next,l2);
            }
        }
    }
}
