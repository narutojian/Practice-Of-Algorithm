package LeetCode;

import java.util.Arrays;

public class P322_Solution2 {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins,int kind,int amount,int num) {
        if (amount == 0) {
            ans = Math.min(ans,num);
            return;
        }
        int turn = amount/coins[kind];
        if (kind == 0) {
            if (amount%coins[kind] != 0) return;
            dfs(coins,-1,0,num+turn);
            return;
        }
        if (amount % coins[kind] == 0) {
            dfs(coins,kind-1,0,num+turn);
            return;
        }

        for (;turn >= 0 && num+turn < ans;turn--) {
            dfs(coins,kind-1,amount - turn*coins[kind],num+turn);
        }
    }

    public static void main(String[] args) {
        P322_Solution2 h = new P322_Solution2();
//        int[] coins = {186,419,83,408};
//        int amount = 6249;
        int[] coins = {470,18,66,301,403,112,360};
        int amount = 8235;
        System.out.println(h.coinChange(coins,amount));
    }
}
