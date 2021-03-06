package LeetCode.Next_Greater_Element_II;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    /**
     * 单调栈 循环数组
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i%n]) {
                res[deque.pop()] = nums[i%n];
            }
            deque.push(i%n);
        }
        return res;
    }
}
