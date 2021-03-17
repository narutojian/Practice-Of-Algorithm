package LeetCode.Coin_Change;

public class Solution5 {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];// 备忘录
        return minCoins(coins,amount);
    }

    /**
     * 递归
     * @param coins
     * @param amount
     * @return
     */
    private int minCoins(int[] coins,int amount) {
        if (amount == 0)
            return 0;
        if (dp[amount] != 0)
            return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if ((amount - coin) < 0)
                continue;
            if (minCoins(coins,amount-coin) == -1)
                continue;
            min = Math.min(min,1+minCoins(coins,amount-coin));
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();

        int[] coins = {2};
        int amount = 3;

        System.out.println(solution5.coinChange(coins,amount));
    }
}
