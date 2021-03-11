package LeetCode.Palindrome_Linked_List;

public class Solution3 {

    ListNode left;// 左指针

    /**
     * 递归 优化
     * 模拟双指针判断是否为回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return retrieve(head);
    }

    private boolean retrieve(ListNode right) {
        if (right == null)
            return true;
        boolean res = retrieve(right.next);
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }
}
