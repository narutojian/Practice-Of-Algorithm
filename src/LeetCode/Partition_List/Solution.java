package LeetCode.Partition_List;

public class Solution {
    /**
     * 三个指针
     * cur指向当前遍历的节点
     * pre指向前一个节点 用来进行删除节点操作
     * xPos指向当前小于x的最后一个节点 xPos.next为下一个小于x的节点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 自定义头节点
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode xPos = sentry;// x的初始位置在头节点处
        ListNode pre = sentry;// 前节点
        ListNode cur = pre.next;// 当前节点

        while (cur != null) {
            if (x <= cur.val) {
                pre = cur;
                cur = cur.next;
            }
            else {
                // 断开cur的指针
                pre.next = cur.next;
                // 在xPos后面插入cur指针
                cur.next = xPos.next;
                xPos.next = cur;

                if (pre == xPos) {
                    pre = pre.next;
                }
                cur = pre.next;
                // 更新xPos和cur
                xPos = xPos.next;
            }
        }
        return sentry.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(2);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        int x = 3;
        solution.partition(head,3);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
