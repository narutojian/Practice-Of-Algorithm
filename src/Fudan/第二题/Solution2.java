package Fudan.第二题;

public class Solution2 {

    /**
     * 计算跳法的接口
     * 给定台阶数 返回跳法的总数
     * @param n 台阶数
     * @return 跳法总数
     */
    public long jumpStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int n = 85;

        System.out.println(solution2.jumpStairs(n));
    }
}
