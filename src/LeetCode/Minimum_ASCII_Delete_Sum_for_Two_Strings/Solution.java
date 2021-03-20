package LeetCode.Minimum_ASCII_Delete_Sum_for_Two_Strings;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings
 */
public class Solution {

    private int m;
    private int n;

    /**
     * 暴力递归 超时
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        return getMinVal(s1,0,s2,0);
    }

    private int getMinVal(String s1,int i,String s2,int j) {
        int val = 0;
        if (i == m) {
            for (int k = j; k < n; k++) {
                val += s2.charAt(k);
            }
            return val;
        }
        if (j == n) {
            for (int k = i; k < m; k++) {
                val += s1.charAt(k);
            }
            return val;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return getMinVal(s1,i+1,s2,j+1);
        }
        else {
            return Math.min(s1.charAt(i)+getMinVal(s1,i+1,s2,j),s2.charAt(j)+getMinVal(s1,i,s2,j+1));
        }
    }
}
