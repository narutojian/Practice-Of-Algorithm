package LeetCode.Coin_Change;

import java.util.Arrays;

/**
 * 22. Coin Change
 */
public class Solution {
    int res = Integer.MAX_VALUE;

    /**
     * 贪心+回溯
     * 找出所有可能性 选择其中最少的组合
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        for (int i = coins.length-1; i > -1; i--) {
            dfs(i,0,0,amount,coins);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int start,int nums,int sum,int amount,int[] coins) {
        if (sum == amount) {
            res = nums;
        }
        if (start < 0) return;

        for (int i = (amount-sum)/coins[start]; i >= 0 && i+nums < res; i--) {
            dfs(start-1,i+nums,sum+i*coins[start],amount,coins);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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
        System.out.println(solution.coinChange(coins,amount));
    }
}
