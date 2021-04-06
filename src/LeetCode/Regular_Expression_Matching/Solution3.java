package LeetCode.Regular_Expression_Matching;

public class Solution3 {
    private int n;
    private int m;

    /**
     * 递归
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
            if (i > -1 && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)))
                res = res || isMatch(s,i-1,p,j);
            return res;
        }
        else {
            if (i > -1 && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)))
                return isMatch(s,i-1,p,j-1);
            return false;
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        String s = "aa";
        String p = "a*";

        System.out.println(solution3.isMatch(s,p));
    }
}
