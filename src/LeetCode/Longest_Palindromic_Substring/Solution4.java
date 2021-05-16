package LeetCode.Longest_Palindromic_Substring;

public class Solution4 {
    private int n;

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        n = s.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len = Math.max(expand(s,i,i),expand(s,i,i+1));
            if (len > (end-start+1)) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expand(String s,int left,int right) {
        if (right >= n || s.charAt(left) != s.charAt(right))
            return 1;

        while (left > 0 && right < n-1) {
            if (s.charAt(left-1) == s.charAt(right+1)) {
                left--;
                right++;
            }
            else break;
        }
        return right-left+1;
    }
}
