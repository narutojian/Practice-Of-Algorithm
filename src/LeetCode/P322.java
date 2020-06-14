package LeetCode;

import java.util.Arrays;

public class P322 {
    int[] w;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        w = coins;
        Arrays.sort(w);
        return dfs(coins.length-1,amount,0);
    }

    public int dfs(int kind,int amount,int num) {
        if (amount == 0) return num;
        if (kind == -1) return -1;

        int turn = amount/w[kind];
        for (;turn >= 0;turn--) {
            int temp =dfs(kind-1,amount-turn*w[kind],num+turn);
            if (temp != -1) return temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        P322 h = new P322();
//        int[] coins = {1,2,5};
//        int amount = 11;
//        int[] coins = {2,3};
//        int amount = 10;
//        int[] coins = {2};
//        int amount = 3;
//        int[] coins = {186,419,83,408};
//        int amount = 6249;
        int[] coins = {470,18,66,301,403,112,360};
        int amount = 8235;
        System.out.println(h.coinChange(coins,amount));
    }
}
