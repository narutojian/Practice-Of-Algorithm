package LeetCode.Coin_Change;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution4 {

    /**
     * 可以看成BFS求最短路径的问题
     * 此处的每种硬币都可以看成点
     * 点与点之间的权重为1
     * 从值为0的点开始出发 求到值为amount的点的最短路径
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // int[]的内容为：当前点的值（钱数）；路径的长度
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();// 去除掉重复的点
        // 初始化
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == amount) {
                return cur[1];
            }
            for (int i = 0; i < coins.length; i++) {
                int curVal = cur[0]+coins[i];
                // 值大于amount的点没必要加进队列中 已经存在的点也没必要加进队列中
                if (curVal <= amount && set.add(curVal))
                    queue.add(new int[]{curVal,cur[1]+1});
            }
        }
        return -1;
    }
}
