package LeetCode.Regular_Expression_Matching;

/**
 * 10. Regular Expression Matching
 */
public class Solution {

    private int n;
    private int m;

    /**
     * 暴力递归
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();

        return isMatch(s,n-1,p,m-1);
    }

    private boolean isMatch(String s,int i,String p,int j) {
        if (i == -1 && j == -1)
            return true;
        if (j == -1)
            return false;

        if (p.charAt(j) == '*') {
            boolean res = isMatch(s,i,p,j-2);
            char pre = p.charAt(j-1);
            for (int k = i; k > -1; k--) {
                if (pre == '.' || pre == s.charAt(k))
                    res = res || isMatch(s,k-1,p,j-2);
                else break;
            }
            return res;
        }
        else {
            if (i > -1 && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)))
                return isMatch(s,i-1,p,j-1);
            return false;
        }
    }
}
