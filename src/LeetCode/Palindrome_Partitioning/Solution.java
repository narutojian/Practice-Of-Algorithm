package LeetCode.Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class Solution {
    int n;
    List<List<String>> res = new ArrayList<>();

    /**
     * dp + 回溯
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i > -1; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                }
                else {
                    boolean flag = s.charAt(i) == s.charAt(j);
                    if (i == j-1 && flag) {
                        dp[i][j] = true;
                    }
                    else if (dp[i+1][j-1] && flag) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        dfs(0,new ArrayList<>(),dp,s);
        return res;
    }
    private void dfs(int start,List<String> ans,boolean[][] dp,String s) {
        if (start == n) {
            // 添加一个结果
            List<String> temp = new ArrayList<>();
            for (String i : ans) {
                temp.add(i);
            }
            res.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                ans.add(s.substring(start,i+1));
                dfs(i+1,ans,dp,s);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String s = "addacd";

        String s = "cbbbcc";

        System.out.println(solution.partition(s));
    }
}
