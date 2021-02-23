package LeetCode.Reverse_Linked_List;

public class Solution3 {

    /**
     * 递归 超精简代码
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
