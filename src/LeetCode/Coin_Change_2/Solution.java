package LeetCode.Coin_Change_2;

/**
 * 518. Coin Change 2
 */
public class Solution {
    private int res = 0;
    private int n;

    /**
     * 暴力递归
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        n = coins.length;
        makeUp(amount,coins,0);
        return res;
    }

    private void makeUp(int amount,int[] coins,int choice) {
        if (amount == 0) {
            res++;
            return;
        }
        if (choice == n)
            return;
        int num = amount/coins[choice];

        for (int i = 0; i < num + 1; i++) {
            makeUp(amount-i*coins[choice],coins,choice+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int amount = 5;
        int[] coins = {1,2,5};

        System.out.println(solution.change(amount,coins));
    }
}
