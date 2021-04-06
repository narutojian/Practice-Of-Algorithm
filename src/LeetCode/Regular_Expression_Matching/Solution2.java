package LeetCode.Regular_Expression_Matching;

import java.util.Arrays;

public class Solution2 {
    private int n;
    private int m;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        int[][] memo = new int[n+1][m+1];
        for (int[] row : memo) {
            Arrays.fill(row,-1);
        }
        return isMatch(s,n,p,m,memo);
    }

    private boolean isMatch(String s,int i,String p,int j,int[][] memo) {
        if (i == 0 && j == 0)
            return true;
        if (j == 0)
            return false;
        if (memo[i][j] != -1)
            return memo[i][j] == 0 ? false : true;
        if (p.charAt(j-1) == '*') {
            boolean res = isMatch(s,i,p,j-2,memo);
            char pre = p.charAt(j-2);
            for (int k = i; k > 0; k--) {
                if (pre == '.' || pre == s.charAt(k-1))
                    res = res || isMatch(s,k-1,p,j-2,memo);
                else break;
            }
            memo[i][j] = res ? 1 : 0;
        }
        else {
            if (i > 0 && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)))
                memo[i][j] = isMatch(s,i-1,p,j-1,memo) ? 1 : 0;
            else memo[i][j] = 0;
        }
        return memo[i][j] == 0 ? false : true;
    }
}
