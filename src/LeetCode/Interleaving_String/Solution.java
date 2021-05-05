package LeetCode.Interleaving_String;

/**
 * 97. Interleaving String
 */
public class Solution {

    /**
     * 递归 超时
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length())
            return false;
        return isCompose(s1,0,s2,0,s3,0) || isCompose(s2,0,s1,0,s3,0);
    }

    /**
     * target字符串是否为s和t交错形成的
     * @param s 此时需要分割的字符串
     * @param i s字符串当前索引
     * @param t 下一次需要分割的字符串
     * @param j t字符串当前索引
     * @param target 目标字符串
     * @param k taregt当前索引
     * @return s和t是否能交错形成target
     */
    private boolean isCompose(String s,int i,String t,int j,String target,int k) {
        if (k == target.length() && i == s.length() && j == t.length())
            return true;
        // 此时 不能再分割了
        if (i == s.length())
            return false;
        for (int l = i; l < s.length(); l++) {
            if (s.charAt(l) == target.charAt(k+l-i)) {
                if (isCompose(t,j,s,l+1,target,k+l-i+1))
                    return true;
            }
            else break;
        }
        return false;
    }
}
