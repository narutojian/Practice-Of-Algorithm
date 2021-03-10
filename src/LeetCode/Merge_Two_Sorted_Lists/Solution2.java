package LeetCode.Merge_Two_Sorted_Lists;

public class Solution2 {
    ListNode res = new ListNode(0);// 保存为结果的头节点指针 不计入结果中
    ListNode cur = res;// 保存结果链表的最末位置的元素

    /**
     * 递归 优化
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return res.next;
        if (l1 == null) {
            cur.next = l2;
            return mergeTwoLists(null,null);
        }
        else if (l2 == null) {
            cur.next = l1;
            return mergeTwoLists(null,null);
        }
        else {
            if (l1.val > l2.val) {
                cur.next = l2;
                cur = cur.next;
                return mergeTwoLists(l1,l2.next);
            }
            else {
                cur.next = l1;
                cur = cur.next;
                return mergeTwoLists(l1.next,l2);
            }
        }
    }
}
