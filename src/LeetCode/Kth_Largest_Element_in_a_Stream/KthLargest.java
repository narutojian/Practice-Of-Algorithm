package LeetCode.Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */
public class KthLargest {
    int k;
    // 优先队列存储k个最大的数 第一个是最小的数 即第k大的数
    PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        while (priorityQueue.size() > k) {
            priorityQueue.remove();
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k)
            priorityQueue.remove();
        return priorityQueue.peek();
    }
}
