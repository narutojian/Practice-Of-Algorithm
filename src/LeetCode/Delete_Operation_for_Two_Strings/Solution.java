package LeetCode.Delete_Operation_for_Two_Strings;

/**
 * 583. Delete Operation for Two Strings
 */
public class Solution {
    private int m;
    private int n;

    /**
     * 暴力递归 超时
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        return getMinOperations(word1,0,word2,0);
    }

    private int getMinOperations(String word1,int i,String word2,int j) {
        if (i == m)
            return n-j;
        if (j == n)
            return m-i;
        if (word1.charAt(i) == word2.charAt(j)) {
            return getMinOperations(word1,i+1,word2,j+1);
        }
        else {
            return Math.min(1+getMinOperations(word1,i+1,word2,j),1+getMinOperations(word1,i,word2,j+1));
        }
    }
}
