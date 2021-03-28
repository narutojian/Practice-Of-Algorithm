package LeetCode.Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 */
public class Solution {

    /**
     * 递归 超时
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        return isSegment(s,0,set);
    }

    /**
     * 定义 在s的[left,s.length-1)的区间上是否可以分割为set中的字符串
     * @param s
     * @param left
     * @param set
     * @return
     */
    private boolean isSegment(String s,int left,Set<String> set) {
        if (left == s.length())
            return true;
        for (int i = left; i < s.length(); i++) {
            if (set.contains(s.substring(left,i+1))) {
                if (isSegment(s,i+1,set))
                    return true;
            }
        }
        return false;
    }
}
