package LeetCode.problem1143;

/**
 * 递归求解,并将求得的数据进行打表记录.
 */
public class P1143_Solution2 {
    String s1;
    String s2;
    int[][] res;
    int ans = 0;

    public int LCS(int x,int y) {
        if (x < 0 || y < 0)
            return 0;
        if (res[x][y] != -1)
            return res[x][y];
        if (x == 0 || y == 0){
            if (s1.charAt(x) == s2.charAt(y))
                res[x][y] = 1;
            else res[x][y] = 0;
        }

        if (s1.charAt(x) == s2.charAt(y))
            res[x][y] = LCS(x-1,y-1)+1;
        else res[x][y] = Math.max(LCS(x-1,y),LCS(x,y-1));

        if (ans < res[x][y])
            ans = res[x][y];

        return res[x][y];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        res = new int[text1.length()][text2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                res[i][j] = -1;
            }
        }

        LCS(s1.length()-1,s2.length()-1);

        return ans;
    }
}
