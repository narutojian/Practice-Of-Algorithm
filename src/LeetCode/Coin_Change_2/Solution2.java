package LeetCode.Coin_Change_2;

import java.util.*;

public class Solution2 {

    private int n;
    private Map<Integer,Integer> memo;
    private int res = 0;

    /**
     * 递归 存储所有状态
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        n = coins.length;
        memo = new HashMap<>();
        memo.put(0,1);
        makeUp(amount,coins,0);
        return res;
    }

    private void makeUp(int amount,int[] coins,int start) {
        if (start == n)
            return;
        Map<Integer,Integer> tempMap = new HashMap<>(memo);
        for (int key : tempMap.keySet()) {
            int tempKey = key;
            while (tempKey < amount) {
                tempKey += coins[start];
                if (tempKey == amount) {
                    res += tempMap.get(key);
                }
                if (tempKey < amount) {
                    // 此时需要加入map中 对应的值就为memo中现在tempKey的值 与 之前map中的key的值 的和
                    memo.put(tempKey,memo.getOrDefault(tempKey,0)+tempMap.get(key));
                }
            }
        }
        makeUp(amount,coins,start+1);
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

        int amount = 5;
        int[] coins = {1,2,5};

        System.out.println(solution2.change(amount,coins));
    }
}
