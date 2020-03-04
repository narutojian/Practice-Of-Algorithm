package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P994 {
    /**
     * BFS
     * @param grid 输入二维数组
     * @return 时间/分钟
     */
    public int orangesRotting(int[][] grid) {
        // 存一下新鲜的橘子数量 curRot是当前时刻下对周围还有影响的坏橘子的数量，nextRot为下一时刻的对周围还有影响的坏橘子数量
        int freshOrange = 0,ans = 0,curRot = 0,nextRot = 0;
        int row = grid.length;// 行
        int column = grid[0].length;// 列
        Deque<Integer> deque = new ArrayDeque<>();// 队列

        // 初始化 确定共有多少个好橘子和当前时刻下对周围还有影响的坏橘子的数量，并将这些坏橘子入队
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) freshOrange++;
                else if (grid[i][j] == 2) {
                    deque.add(i);
                    deque.add(j);
                    curRot++;
                }
            }
        }
        // 特判 没有好橘子了 直接0
        if (freshOrange == 0) return ans;
        int i,j;
        // 上下左右的方向值
        int[] horizon = new int[] {0,0,-1,1};
        int[] vertical = new int[] {-1,1,0,0};
        // 开始BFS
        // 其中curRot为0的时候，说明以及过了当前这一分钟了，也就说好橘子被感染的已经感染了
        // nextRot就是用来记录在当前这一分钟后，有多少个好橘子被糟蹋了，并将这些变为坏橘子的标记入队，下一次就轮到他们去感染周围的橘子了
        while (!deque.isEmpty() && freshOrange != 0) {
            while (curRot != 0) {
                i = deque.remove();
                j = deque.remove();
                curRot--;
                for (int k = 0;k < 4;k++) {
                    int l = i+vertical[k];
                    int m = j+horizon[k];
                    if (l >= 0 && l < row && m >= 0 && m < column && grid[l][m] == 1){
                        grid[l][m] = 2;
                        freshOrange--;
                        deque.add(l);
                        deque.add(m);
                        nextRot++;
                    }
                }
            }
            // 将时间加1
            ans++;
            curRot = nextRot;
            nextRot = 0;
        }
        // 如果队列中没有可以在影响周围的坏橘子的时候，看看是否还有好橘子，如果有，说明那个好橘子的周围定没有坏橘子
        // 这个周围是指他的上下左右
        // 也就说这种情况，返回-1
        if (freshOrange != 0) return -1;
        return ans;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] {
//                {2,1,1},
//                {1,1,0},
//                {0,1,1}
//        };
//        int[][] grid = new int[][] {
//                {2,1,1},
//                {0,1,1},
//                {1,0,1}
//        };
        int[][] grid = new int[][] {
                {0,2}
        };
        P994 h = new P994();
        System.out.println(h.orangesRotting(grid));
    }
}
