package LeetCode.Longest_Palindromic_Substring;

public class Solution3 {

    /**
     * dp 空间优化
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] prev = new boolean[n];
        boolean[] cur = new boolean[n];
        int maxLen = 1;
        String ans = s.substring(0,1);
        prev[n-1] = true;
        for (int i = n-2; i > -1; i--) {
            for (int j = i; j < n; j++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                if (i == j)
                    cur[j] = true;
                else if (j == i+1 && flag)
                    cur[j] = true;
                else cur[j] = prev[j-1] && flag;
                if (cur[j] && maxLen < (j-i+1)) {
                    maxLen = j-i+1;
                    ans = s.substring(i,j+1);
                }
            }
            for (int j = i; j < n; j++) {
                prev[j] = cur[j];
            }
        }

        return ans;
    }
}
