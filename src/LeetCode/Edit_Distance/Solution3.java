package LeetCode.Edit_Distance;

public class Solution3 {

    /**
     * 递归 + 备忘录
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }

        return getMin(word1,word2,n1-1,n2-1,dp);
    }

    private int getMin(String word1,String word2,int index1,int index2,int[][] dp) {
        if (index1 == -1)
            return index2+1;
        if (index2 == -1)
            return index1+1;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (word1.charAt(index1) == word2.charAt(index2)) {
            dp[index1][index2] = getMin(word1,word2,index1-1,index2-1,dp);
        }
        else {
            int fir = getMin(word1,word2,index1,index2-1,dp)+1;// 插入操作
            int sec = getMin(word1,word2,index1-1,index2,dp)+1;// 删除操作
            int thi = getMin(word1,word2,index1-1,index2-1,dp)+1;// 替换操作
            dp[index1][index2] = Math.min(fir,Math.min(sec,thi));
        }
        return dp[index1][index2];
    }
}
