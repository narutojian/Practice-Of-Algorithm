package LeetCode.Clumsy_Factorial;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    /**
     * 模拟 栈
     * @param N
     * @return
     */
    public int clumsy(int N) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(N--);

        int operation = 0;
        while (N > 0) {
            operation %= 4;
            if (operation == 0) {
                deque.push(deque.pop()*N);
            }
            else if (operation == 1) {
                deque.push(deque.pop()/N);
            }
            else if (operation == 2) {
                deque.push(N);
            }
            else deque.push(-N);
            N--;
            operation++;
        }
        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }
}
