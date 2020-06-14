package LeetCode.problem206;

public class P206 {
    ListNode ans = null;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        recursion2(null,head);
        return ans;
    }

    /**
     * 递归反转链表
     * @param pre
     * @param cur
     */
    private void recursion2(ListNode pre,ListNode cur) {
        if (cur.next != null) {
            recursion2(cur,cur.next);
        }
        else ans = cur;
        if (pre != null){
            pre.next = null;
            cur.next = pre;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;
        P206 h = new P206();
        h.reverseList(first);
    }
}
