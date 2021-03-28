package LeetCode.Word_Break_II;

import java.util.*;

/**
 * 140. Word Break II
 */
public class Solution {
    private int n;

    /**
     * 递归 记忆化
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        n = s.length();
        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        List<String>[][] memo = new List[n][n];
        for (List<String>[] row : memo) {
            Arrays.fill(row, null);
        }

        return getSegmentString(s,0,set,memo);
    }

    private List<String> getSegmentString(String s,int left,Set<String> set,List<String>[][] memo) {
        if (left == n)
            return null;
        if (memo[left][n-1] != null)
            return memo[left][n-1];
        memo[left][n-1] = new LinkedList<>();
        for (int i = left; i < n; i++) {
            if (set.contains(s.substring(left,i+1))) {
                String cur = s.substring(left,i+1);
                if (getSegmentString(s,i+1,set,memo) == null) {
                    // 说明此时[left,i+1]就已经为[left,n-1]了
                    memo[left][n-1].add(cur);
                }
                else {
                    // 此时 s的[i+1,n-1] 可以分割为set中的字符串
                    if (memo[i+1][n-1].size() != 0) {
                        for (String temp : memo[i + 1][n - 1]) {
                            StringBuilder res = new StringBuilder(cur);
                            memo[left][n - 1].add(res.append(" ").append(temp).toString());
                        }
                    }
                }
            }
        }
        return memo[left][n-1];
    }
}
