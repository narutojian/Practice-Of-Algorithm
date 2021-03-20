package LeetCode.Longest_Common_Subsequence;

/**
 * 1143. Longest Common Subsequence
 */
public class Solution {

    /**
     * 暴力递归 超时
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        for (int i = 0; i < text1.length(); i++) {
            res = Math.max(res,getCommonLength(text1,text2,i,0));
        }
        return res;
    }

    /**
     * 定义 在text1的[index1,text1.length) 与 text2的[index2,text2.length) 找出以text1的index1为第一个字符的最长的公共子序列 并返回长度
     * @param text1 1
     * @param text2 2
     * @param index1 1的起始位置
     * @param index2 2的起始位置
     * @return 最长的公共子序列的长度
     */
    private int getCommonLength(String text1,String text2,int index1,int index2) {
        if (index1 == text1.length() || index2 == text2.length())
            return 0;

        if (text1.charAt(index1) == text2.charAt(index2)) {
            int max = 1;
            for (int i = index1+1; i < text1.length(); i++) {
                max = Math.max(max,1+getCommonLength(text1,text2,i,index2+1));
            }
            return max;
        }
        return getCommonLength(text1,text2,index1,index2+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(solution.longestCommonSubsequence(text1,text2));
    }
}
