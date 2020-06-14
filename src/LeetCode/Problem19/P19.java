package LeetCode.problem19;

/**
 * 解题思路：
 * 先一趟遍历node，计算出链表的长度length
 * 然后用length-n得出该删的节点的前一个节点
 * 正常情况下，length-n肯定是大于0的，即正数第1，2，3，4.。。个数
 * 但有一种特殊情况，那就是length - n = 0；
 * 这种情况就表示此时要删除的节点是头节点。
 */
public class P19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode start = head;
        ListNode temp = head;
        int length = 1;

        while (start.next != null) {
            length++;
            start = start.next;
        }

        int index = length -n;
        if (index == 0) return ans.next;
        while (index > 1) {
            temp = temp.next;
            index --;
        }

        temp.next = temp.next.next;
        return ans;
    }
}
