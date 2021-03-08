package LeetCode.Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    int n;
    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();

    /**
     * 优化代码
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = n-2; i > -1; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }

        dfs(0,new ArrayList<>(),s);

        return res;
    }

    private void dfs(int start,List<String> ans,String s) {
        if (start == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                ans.add(s.substring(start,i+1));
                dfs(i+1,ans,s);
                ans.remove(ans.size()-1);
            }
        }
    }
}
