package LeetCode.problem876;

public class P876 {

    /**
     * 数组存储节点，返回中间节点
     * @param head 头指针
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] listNodes = new ListNode[100];
        int index = 0;

        while (head != null) {
            listNodes[index++] = head;
            head = head.next;
        }

        return listNodes[index/2];
    }

    /**
     * 快慢指针优化空间，省去数组
     * @param head 头指针
     * @return 中间节点
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
