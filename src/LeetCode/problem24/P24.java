package LeetCode.problem24;

/**
 * 画图 归纳总结规律
 */
public class P24 {

    private ListNode top;

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        swapNode(null,head);
        return top;
    }

    private void swapNode(ListNode pre,ListNode cur) {
        if (cur == null || cur.next == null) return;

        ListNode next = cur.next;
        cur.next = next.next;

        if (pre != null) pre.next = next;
        next.next = cur;
        if (pre == null) top = next;
        swapNode(cur,cur.next);
    }

    public static void main(String[] args) {
        P24 h = new P24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = h.swapPairs(node1);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
}
