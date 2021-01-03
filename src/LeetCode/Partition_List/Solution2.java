package LeetCode.Partition_List;

public class Solution2 {

    /**
     * 官方题解
     * 将小于x的放到smallHead链表中 大于等于x的放到largeHead链表中
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallHead = small;
        ListNode largeHead = large;

        while (head != null) {
            if (x <= head.val) {
                // 后插法
                large.next = head;
                large = large.next;
            }
            else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

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

        solution2.partition(head,x);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
