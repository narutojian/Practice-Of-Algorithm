package LeetCode.Reverse_Linked_List;

/**
 * 206. Reverse Linked List
 */
public class Solution {
    ListNode res = null;

    /**
     * 递归遍历
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        reverseList(null,head);
        return res;
    }

    private void reverseList(ListNode pre,ListNode cur) {
        if (cur == null) return;

        reverseList(cur,cur.next);
        if (res == null) {
            res = cur;
        }
        cur.next = pre;
    }
}
