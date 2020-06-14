package LeetCode.problem155;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> store;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        store = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        store.push(x);
        if (stack.isEmpty() || x <= stack.peek()) stack.push(x);
    }

    public void pop() {
//        int x = store.pop();
//        if (stack.peek() == x) stack.pop();
        if (stack.peek().equals(store.pop())) stack.pop();
//        这里stack.peek() == store.pop()有问题 最好还是用equals
//        if (stack.peek() == store.pop()) stack.pop();
    }

    public int top() {
        return store.peek();
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
