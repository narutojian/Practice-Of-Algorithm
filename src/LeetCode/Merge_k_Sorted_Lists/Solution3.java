package LeetCode.Merge_k_Sorted_Lists;

import LeetCode.DS.ListNode;

public class Solution3 {

    /**
     * 分治合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return mergeList(lists,0,n-1);
    }

    /**
     * 定义 合并lists的[left,right]区间的列表，并且该列表依旧保持有序
     * @param lists 列表集合
     * @param left 左边界
     * @param right 右边界
     * @return 返回合并后的列表
     */
    public ListNode mergeList(ListNode[] lists,int left,int right) {
        if (left > right)
            return null;
        if (left == right)
            return lists[left];
        int mid = left+(right-left)/2;
        ListNode fir = mergeList(lists,left,mid);// 左边区间的子列表
        ListNode sec = mergeList(lists,mid+1,right); // 右边区间的子列表
        ListNode sentry = new ListNode();
        ListNode cur = sentry;
        while (fir != null && sec != null) {
            if (fir.val < sec.val) {
                cur.next = fir;
                fir = fir.next;
            }
            else {
                cur.next = sec;
                sec = sec.next;
            }
            cur = cur.next;
        }
        if (fir != null)
            cur.next = fir;
        if (sec != null)
            cur.next = sec;
        return sentry.next;
    }
}
