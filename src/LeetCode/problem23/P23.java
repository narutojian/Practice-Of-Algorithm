package LeetCode.problem23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23 {

    /**
     * 优先队列 合并链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.add(lists[i]);
        }

        while (!queue.isEmpty()) {
            ListNode cur = queue.remove();
            temp.next = cur;
            temp = temp.next;
            if (cur.next != null) queue.add(cur.next);
        }

        return ans.next;
    }

    public static void main(String[] args) {
        P23 h = new P23();

        ListNode[] lists = {null};
        System.out.println(h.mergeKLists(lists));
    }
}
