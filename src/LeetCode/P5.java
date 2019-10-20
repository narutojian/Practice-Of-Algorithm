package LeetCode;

/**
 * solution 1：
 * 回文串是正着看和反着看都是一样的字符串，所以它有一个特点，那就是对称。
 * 分两种情况：
 * 一种是特殊情况，那就是字符串中所有字符都是一样的，那么此时字符串的长度可以是偶数也可以是奇数。
 * 一种是普遍情况，那就是字符串中有各种各样的字符，那么此时字符串的长度就是奇数的。
 *
 * 那么，基于以上的特点，我就是可以从字符串的中心字符开始。
 */
public class P5 {

    /**
     * 暴力解法 空间复杂度 O(n^3)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String res = ""+s.charAt(0);
        int start,end;
        boolean flag;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                start = i;
                end = j;
                flag = true;
                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)){
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }

                if (flag && res.length() < (j-i+1))
                    res = s.substring(i,j+1);
            }
        }
        return res;
    }

    /**
     * 动态规划 时间复杂度 O(n^2),空间复杂度 O(n^2)
     * 设 P(i,j)为判断从i到j的字符组成的字符串是否为回文串。
     * 所以P(i,j) = (P(i+1,j-1) && s[i] == s[j]);
     * 首先，长度为1的字符串肯定为回文串，然后在判断长度为2的字符串中哪个为回文串，
     * 依此类推，直到长度为n的字符串是否为回文串。
     * 在每次判断中，更新最长的回文子串。
     * @return
     */
    public String longestPalindrome_1(String s) {
        if (s.equals(""))
            return s;
        char[] c = s.toCharArray();
        int start = 0,end = 0,res = 0;
        boolean[][] arr = new boolean[c.length][c.length];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < (c.length-i); j++) {
                if (i == 0) arr[j][j] = true;
                else if (i == 1) {
                    if (c[j] == c[j+i]){
                        arr[j][j+i] = true;
                        if (res < i) {
                            res = i;
                            start = j;
                            end = j+i;
                        }
                    }
                }
                else {
                    if (arr[j+1][j+i-1] && c[j] == c[j+i]){
                        arr[j][j+i] = true;
                        if (res < i){
                            res = i;
                            start = j;
                            end = j+i;
                        }
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String s = "abcba";
//        System.out.println(new P5().longestPalindrome(s));
        System.out.println(new P5().longestPalindrome_1(s));
    }
}
