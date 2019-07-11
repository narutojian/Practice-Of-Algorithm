package LeetCode.Problem2;

import org.junit.Test;

public class TestAll {

    @Test
    public void test1(){

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        for (int i = 0; i < 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println("temp's value:"+temp.val);
        System.out.println("res's value:"+res.val);
    }
}
