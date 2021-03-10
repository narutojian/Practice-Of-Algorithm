package LeetCode.Merge_Two_Sorted_Lists;

public class Solution3 {

    /**
     * 官方题解 太nb了
     * @param l1 合并链表1
     * @param l2 合并链表2
     * @return 返回合并后的链表的首节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
