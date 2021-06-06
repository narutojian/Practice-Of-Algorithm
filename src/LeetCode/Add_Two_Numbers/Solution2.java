package LeetCode.Add_Two_Numbers;

import LeetCode.DS.ListNode;

public class Solution2 {

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1,l2,0);
    }

    private ListNode dfs(ListNode l1,ListNode l2,int add) {
        if (l1 == null && l2 == null && add == 0)
            return null;
        int first = l1 == null ? 0 : l1.val;
        int sec = l2 == null ? 0 : l2.val;
        int sum = first+sec+add;
        ListNode node = new ListNode(sum%10);
        node.next = dfs(l1 == null ? null : l1.next,l2 == null ? null : l2.next,sum/10);
        return node;
    }
}
