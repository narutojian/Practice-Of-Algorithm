package LeetCode.Reverse_Nodes_in_k_Group;

public class Solution2 {

    /**
     * 递归 优化
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode a = head;
        ListNode b = head;
        int num = k;
        while (num > 0) {
            if (b == null)
                return head;
            b = b.next;
            num--;
        }
        ListNode res = reverseN(a,k);
        a.next = reverseKGroup(b,k);
        return res;
    }

    private ListNode reverseN(ListNode head,int k) {
        if (k == 1) {
            return head;
        }
        ListNode res = reverseN(head.next,k-1);
        head.next.next = head;
        return res;
    }
}
