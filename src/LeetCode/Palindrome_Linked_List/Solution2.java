package LeetCode.Palindrome_Linked_List;

public class Solution2 {
    ListNode first;
    boolean res = true;

    /**
     * 递归
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        first = head;
        compareList(head);
        return res;
    }

    private void compareList(ListNode head) {
        if (head == null) {
            return;
        }
        compareList(head.next);
        if (head.val != first.val)
            res = false;
        first = first.next;
    }
}
