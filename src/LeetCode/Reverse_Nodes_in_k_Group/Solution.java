package LeetCode.Reverse_Nodes_in_k_Group;

/**
 * 25. Reverse Nodes in k-Group
 */
public class Solution {

    ListNode successor;

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 1;
        ListNode temp = head;
        // 计数
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        ListNode res = reverseN(head,k);
        ListNode pre = head;
        n -= k;
        while (n > k) {
            temp = successor;
            ListNode curHead = reverseN(successor,k);
            pre.next = curHead;
            pre = temp;
            n -= k;
        }
        return res;
    }

    private ListNode reverseN(ListNode head,int n) {
        if (n == 1) {
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
        int k = 2;

        ListNode res = solution.reverseKGroup(head,k);
        while (res != null) {
            System.out.print(res.val+"  ");
            res = res.next;
        }
    }
}
