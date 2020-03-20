package LeetCode.problem1548;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 */
public class MaxQueue {
    //此队列用来存放数据
    private Queue<Integer> queue;
    //此队列为单调队列，维护上面那个队列的最大值
    private Deque<Integer> monotoneQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        monotoneQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        return monotoneQueue.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!monotoneQueue.isEmpty() && monotoneQueue.getLast() < value)
            monotoneQueue.removeLast();
        monotoneQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        if (queue.peek().equals(monotoneQueue.getFirst()))
            monotoneQueue.remove();
        return queue.remove();
    }
}
