package LeetCode.Problem2;

public class P2 {

    ListNode res;
    ListNode node;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if (l1 == null && l2 == null)
            return res;
        if (l1 == null){

            while (l2.val/10 != 0){
                node.next = new ListNode(l2.val%10);
                node = node.next;

                l2 = l2.next;
                if (l2 == null) {
                    l2 = new ListNode(1);
                    break;
                }
                else l2.val++;
            }
            if (l2 != null)
                node.next = l2;
            return res;
        }
        if (l2 == null){

            while (l1.val/10 != 0){
                node.next = new ListNode(l1.val%10);
                node = node.next;
                l1 = l1.next;

                if (l1 == null){
                    l1 = new ListNode(1);
                    break;
                }
                else l1.val++;
            }
            if (l1 != null)
                node.next = l1;
            return res;
        }

        int temp = l1.val+l2.val;
        int temp1;
        if (temp/10 != 0)
            temp1 = temp%10;
        else temp1 = temp;

        l1 = l1.next;
        l2 = l2.next;

        if (res == null) {
            res = new ListNode(temp1);
            node = res;
        }
        else {
            node.next = new ListNode(temp1);
            node = node.next;
        }

        if (temp/10 != 0){

            if (l1 != null)
                l1.val++;
            else if (l2 != null)
                l2.val++;
            else node.next = new ListNode(1);
        }

        return addTwoNumbers(l1,l2);
    }
}
