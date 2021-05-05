package LeetCode.Interleaving_String;

public class Solution2 {
    private int m;
    private int n;
    private int len;

    /**
     * 暴力搜索 优化递归
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        len = s3.length();
        if (n+m != len)
            return false;
        return isCompose(s1,0,s2,0,s3,0);
    }

    private boolean isCompose(String s1,int i,String s2,int j,String s3,int k) {
        if (i == m && j == n && k == len)
            return true;
        if (i < m) {
            // 如果s1的当前字符与s3的字符相同 可以继续看看下一个
            if (s1.charAt(i) == s3.charAt(k) && isCompose(s1,i+1,s2,j,s3,k+1))
                return true;
        }
        if (j < n) {
            // 同上
            if (s2.charAt(j) == s3.charAt(k) && isCompose(s1,i,s2,j+1,s3,k+1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(solution2.isInterleave(s1,s2,s3));
    }
}
