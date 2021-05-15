package Fudan.第二题;

public class Solution {

    /**
     * 计算跳法的接口
     * 给定台阶数 返回跳法的总数
     * @param n 台阶数
     * @return 跳法总数
     */
    public int jumpStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return jumpStairs(n-1)+jumpStairs(n-2);
    }

}
