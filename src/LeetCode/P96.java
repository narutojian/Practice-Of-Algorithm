package LeetCode;

public class P96 {
    /**
     * 动态规划解决
     * 1. 了解二叉排序树的特性
     * 2. 找出递推公式
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        int index = 3,i,j;
        while (index <= n) {
            i = 1;
            j = index;
            while (i < j) {
                dp[index] += 2*dp[i-1]*dp[index-i];
                i++;
                j--;
            }
            if (i == j) dp[index] += dp[index-i]*dp[i-1];
            index++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P96 h = new P96();
//        int n = 3;
//        int n = 4;
//        int n = 12;
        int n = 19;
        System.out.println(h.numTrees(n));
    }
}
