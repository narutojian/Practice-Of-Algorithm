package LeetCode.Coin_Change;

public class Solution2 {
    /**
     * dp
     * dp[i]: 表示组成钱数为i最少需要几枚硬币
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < dp.length)
                dp[coins[i]] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                for (int j = 0; j < coins.length; j++) {
                    if ((i-coins[j] > -1 && dp[i-coins[j]] != Integer.MAX_VALUE)) {
                        dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        int[] coins = {1,2,5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {1};
//        int amount = 0;

//        int[] coins = {1};
//        int amount = 1;

//        int[] coins = {1};
//        int amount = 2;

//        int[] coins = {186,419,83,408};
//        int amount = 6249;

        int[] coins = {288,160,10,249,40,77,314,429};
        int amount = 9208;

        System.out.println(solution2.coinChange(coins,amount));
    }
}
