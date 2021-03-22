package LeetCode.Coin_Change_2;

import java.util.Arrays;

public class Solution3 {

    private int[][] memo;

    /**
     * dp 递归 记忆化
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n+1][amount+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return makeUp(amount,coins,n);
    }

    /**
     * 定义 在用coins的[0,start-1]的硬币 能构成amount的方案数
     * @param amount
     * @param coins
     * @param start
     * @return
     */
    private int makeUp(int amount,int[] coins,int start) {
        if (amount == 0)
            return 1;
        if (start == 0)
            return 0;
        if (memo[start][amount] != -1)
            return memo[start][amount];

        if (amount-coins[start-1] < 0)
            memo[start][amount] = makeUp(amount,coins,start-1);
        else memo[start][amount] = makeUp(amount,coins,start-1)+makeUp(amount-coins[start-1],coins,start);

        return memo[start][amount];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int amount = 5;
        int[] coins = {1,2,5};

        System.out.println(solution3.change(amount,coins));
    }
}
