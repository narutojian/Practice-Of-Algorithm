package LeetCode.Longest_Palindromic_Substring;

/**
 * 5. Longest Palindromic Substring
 */
public class Solution {

    /**
     * 暴力枚举
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = 1;
        String ans = s.substring(0,1);
        for(int i = 0;i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isPalindromic(s,i,j) && (j-i+1) > len) {
                    len = j-i+1;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(String s,int i,int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
