package LeetCode.Problem21;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 解题思路：
 * 1. 一开始想到的正解是 用队列的思想，把每个节点都放入队列中；
 * 然后比较两个队列的首元素的值的大小，小的就放到我创建的链表后面。
 * 2. 还是上一种的想法，但是这次用一个队列；用优先队列来存储所有的节点，并按从小到大的顺序进行排序
 * 3. 看了别人的解法，发现原来还可以递归求解，emm瞬间感觉我好蠢啊。
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null) return l1;

        Queue<ListNode> queue1 = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        ListNode head = new ListNode(0);
        ListNode ans = head;
        while (l1 != null) {
            queue1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
             queue2.add(l2);
             l2 = l2.next;
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek().val <= queue2.peek().val)
                head.next = queue1.poll();
            else head.next = queue2.poll();
            head = head.next;
        }

        while (!queue1.isEmpty()) {
            head.next = queue1.poll();
            head = head.next;
        }
        while (!queue2.isEmpty()) {
            head.next = queue2.poll();
            head = head.next;
        }
        return ans.next;
    }

    public ListNode mergeTwoLists_2 (ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null) return l1;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode ans = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                queue.add(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                queue.add(l2);
                l2 = l2.next;
            }
        }

        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
        }
        /*
        去除head节点在原链表中指向的节点
         */
        head.next = null;
        return ans.next;
    }

    public ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_3(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists_3(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(-10);
        ListNode a2 = new ListNode(-9);
        ListNode a3 = new ListNode(-6);
        ListNode a4 = new ListNode(-4);
        ListNode a5 = new ListNode(1);
        ListNode a6 = new ListNode(9);
        ListNode a7 = new ListNode(9);

        ListNode b1 = new ListNode(-5);
        ListNode b2 = new ListNode(-3);
        ListNode b3 = new ListNode(0);
        ListNode b4 = new ListNode(7);
        ListNode b5 = new ListNode(8);
        ListNode b6 = new ListNode(8);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;

//        System.out.println(new P21().mergeTwoLists_2(a1,b1));
        System.out.println(new P21().mergeTwoLists_3(a1,b1));
    }
}
