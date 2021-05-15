package LeetCode.Palindrome_Partitioning_II;

/**
 * 132. Palindrome Partitioning II
 */
public class Solution {
    int n;
    boolean[][] dp;
    int res = Integer.MAX_VALUE;

    /**
     * dp + 回溯 剪枝
     * 超时
     * @param s
     * @return
     */
    public int minCut(String s) {
        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = n-2; i > -1; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(0,0);
        return res;
    }

    private void dfs(int start,int cuts) {
        // 剪枝
        if (cuts-1 >= res)
            return;
        if (start == n) {
            res = Math.min(res,cuts-1);
            return;
        }
        for (int i = n-1; i > start-1; i--) {
            if (dp[start][i]) {
                dfs(i+1,cuts+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "aab";

//        String s = "addacd";

//        String s = "cbbbcc";

        System.out.println(solution.minCut(s));
    }
}
