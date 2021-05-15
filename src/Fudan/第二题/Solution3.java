package Fudan.第二题;

import java.math.BigInteger;

public class Solution3 {

    /**
     * 计算跳法的接口
     * 给定台阶数 返回跳法的总数
     * @param n 台阶数
     * @return 跳法总数
     */
    public String jumpStairs(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "2";
        BigInteger first = new BigInteger("1");// dp[1]
        BigInteger second = new BigInteger("2");// dp[2]
        BigInteger next = new BigInteger("0");

        for (int i = 3; i < n+1; i++) {
            next = first.add(second);
            first = second;
            second = next;
        }
        return next.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        /**
         * 45 1836311903
         * 60 2504730781961
         * 70 308061521170129   15位
         * 80 37889062373143906 18位
         * 85 420196140727489673
         * 90 4660046610375530309
         * 100 573147844013817084101
         */
        int n = 45;

        System.out.println(solution3.jumpStairs(n));
    }
}
