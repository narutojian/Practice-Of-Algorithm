package LeetCode.Implement_Queue_using_Stacks;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class MyQueue {
    Stack<Integer> front;
    Stack<Integer> rear;

    /** Initialize your data structure here. */
    public MyQueue() {
        front = new Stack<>();
        rear = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        rear.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (front.isEmpty()) {
            while (!rear.isEmpty()) {
                front.push(rear.pop());
            }
        }
        return front.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (front.isEmpty()) {
            while (!rear.isEmpty()) {
                front.push(rear.pop());
            }
        }
        return front.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (rear.isEmpty() && front.isEmpty())
            return true;
        return false;
    }
}
