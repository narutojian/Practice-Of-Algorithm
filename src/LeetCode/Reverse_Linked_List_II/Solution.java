package LeetCode.Reverse_Linked_List_II;

/**
 * 92. Reverse Linked List II
 */
public class Solution {
    ListNode successor = null;
    /**
     * 将[left,right]的元素逆转，并返回头指针
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head,right);
        }
        ListNode last = reverseBetween(head.next,left-1,right-1);
        head.next = last;
        return head;
    }

    /**
     * 将前n个元素反转，返回头指针
     * @param head
     * @param n
     * @return
     */
    private ListNode reverseN(ListNode head,int n) {
        if (n == 1) {
            // 记录下最后一个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode res = solution.reverseBetween(head,left,right);

        while (res != null) {
            System.out.print(res.val+"  ");
            res = res.next;
        }
    }
}
