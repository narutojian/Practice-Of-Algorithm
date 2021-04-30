package LeetCode.Maximum_Frequency_Stack.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * 895. Maximum Frequency Stack
 */
public class FreqStack {
    private Map<Integer, Stack<Integer>> keyStack;// <指定频率，该频率下的stack>
    private Map<Integer,Integer> freqMap;// <出现的值，该值对应的频率>
    private int maxFreq = -1;// 记录最大频率

    public FreqStack() {
        keyStack = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int val) {
        Integer node = freqMap.get(val);
        if (node == null) {
            Stack<Integer> curStack = keyStack.get(1);
            if (curStack == null)
                curStack = new Stack<>();
            curStack.push(val);
            keyStack.put(1,curStack);
            freqMap.put(val,1);
            maxFreq = Math.max(maxFreq,1);
        }
        else {
            int freq = freqMap.get(val)+1;
            freqMap.put(val,freq);
            maxFreq = Math.max(maxFreq,freq);
            Stack<Integer> curStack = keyStack.get(freq);
            if (curStack == null)
                curStack = new Stack<>();
            curStack.push(val);
            keyStack.put(freq,curStack);
        }
    }

    public int pop() {
        int val = keyStack.get(maxFreq).pop();
        if (freqMap.get(val) == 1)
            freqMap.remove(val);
        else freqMap.put(val,freqMap.get(val)-1);// 更新频率
        if (keyStack.get(maxFreq).size() == 0)
            maxFreq--;
        return val;
    }
}
