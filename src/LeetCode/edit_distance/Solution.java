package LeetCode.edit_distance;

/**
 * 72. Edit Distance
 */
public class Solution {

    /**
     * 动态规划方法
     * @param word1 输入字符串
     * @param word2 目标字符串
     * @return 最短距离，距离越短，两个词越相似
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],1+Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        String word1 = "";
        String word2 = "a";

        System.out.println(h.minDistance(word1,word2));
    }
}
