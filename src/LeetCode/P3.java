package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P3 {

    /**
     * 滑动窗口算法
     * @param s 给定的字符串
     * @return 返回最长不重复子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        // map记录在队列已有的字符
        HashMap<Character, Boolean> map = new HashMap<>();
        // 队列存储当前不重复的字串字符
        Queue<Character> queue = new LinkedList<>();
        int ans = 1;

        for (char i :
                s.toCharArray()) {
            // 如果map没有记录，说明当前队列中没有这个字符，加进去
            if (!map.containsKey(i)) {
                queue.add(i);
                map.put(i,true);
            }
            else {
                // 如果map有，说明队列中有这种字符，为重复字符
                // 更新下ans，准备计算下一个不重复字串的长度
                // 将队列中该字符的前面字符和这个字符都出队，并移除对应的map记录
                // 将这个当前新的字符加进队列
                if (queue.size() > ans) ans = queue.size();
                while (!queue.isEmpty() && !queue.peek().equals(i)) {
                    map.remove(queue.peek());
                    queue.poll();
                }
                queue.poll();
                queue.add(i);
            }
        }

        // 这里可能出现字符串s中没有重复字符，故没有一次更新ans，所以需要比较一下queue的长度和ans
        return Math.max(ans,queue.size());
    }

    /**
     * 滑动窗口算法，优化空间
     * 通过用两个指针来确定窗口的范围，不需要额外空间
     * 另外，可以不使用map记录已经窗口中出现的字符
     * 可以通过两种方式来判定新字符是否重复出现在窗口的范围中
     * 1. 直接循环遍历窗口中的字符，若相等，则说明重复
     * 2. 定义一个128长度的数组，用来表示ASCII 128位符号，用这个数组的索引表示字符，
     * 索引下的数组的值是否等于0判断是否重复
     * @param s 给定字符串
     * @return 返回最长不重复字符串的长度
     */
    public int lengthOfLongestSubstring2(String s) {

        if (s.length() <= 1) return s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int ans = 1 ;
        for (char i : chars) {
            // 判断重复字符
            for (int j = start; j < end; j++) {
                if (chars[j] == i) {
                    start = j + 1;
                    break;
                }
            }

            end++;
            // 每次循环都更新下ans
            ans = Math.max(ans, end - start);
        }
        return ans;
    }

    /**
     * 滑动窗口算法 空间优化 使用128长度数组判重
     * @param s 给定的字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() <= 1) return s.length();

        int[] map = new int[128];
        char[] chars = s.toCharArray();
        int ans = 1,start = 0,end = 0;
        for (char i :
                chars) {
            if (map[i] == 0) map[i]++;
            else {
                ans = Math.max(ans, end-start);
                for (int j = start; j < end; j++) {
                    if (chars[j] == i) {
                        start = j+1;
                        break;
                    }
                    map[chars[j]]--;
                }
            }
            end++;
        }
        return Math.max(ans,end-start);
    }
    public static void main(String[] args) {

        String s = "dvdf";
        System.out.println(new P3().lengthOfLongestSubstring(s));
    }
}
