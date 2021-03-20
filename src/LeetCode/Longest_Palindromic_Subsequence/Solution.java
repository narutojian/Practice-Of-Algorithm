package LeetCode.Longest_Palindromic_Subsequence;

/**
 * 516. Longest Palindromic Subsequence
 */
public class Solution {

    private  int n;

    /**
     * 暴力递归 超时
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        return getLongest(s,0,n-1);
    }

    private int getLongest(String s,int left,int right) {
        if (left > right)
            return 0;
        if (left == right)
            return 1;
        if (s.charAt(left) == s.charAt(right))
            return 2+getLongest(s,left+1,right-1);

        return Math.max(getLongest(s,left+1,right),getLongest(s,left,right-1));
    }
}
