package LeetCode.Word_Break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    private int n;

    /**
     * dp 递归 记忆化
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        int[][] memo = new int[n][n];// 定义：[i][j] 表示 s的[i,j]子字符串是否可以分割为wordDict中的字符串
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        return isSegment(s,0,set,memo);
    }

    private boolean isSegment(String s,int left,Set<String> set,int[][] memo) {
        if (left == n)
            return true;
        if (memo[left][n-1] != -1)
            return memo[left][n-1] == 1 ? true : false;
        memo[left][n-1] = 0;
        for (int i = left; i < s.length(); i++) {
            if (!set.contains(s.substring(left,i+1))) {
                memo[left][i] = 0;
            }
            else {
                memo[left][i] = 1;
                if (isSegment(s,i+1,set,memo)) {
                    memo[left][n-1] = 1;
                    return true;
                }
            }
        }
        return false;
    }
}
