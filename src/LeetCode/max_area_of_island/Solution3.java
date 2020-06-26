package LeetCode.max_area_of_island;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    private int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    private int n;
    private int m;

    /**
     * bfs
     * 时间复杂度 O(nm)
     * 空间复杂度 O(nm)
     * @param grid 01矩阵
     * @return 最大的陆地面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                grid[i][j] = 0;
                queue.add(i*m+j);
                ans = Math.max(ans,bfs(grid,queue));
            }
        }
        return ans;
    }

    private int bfs(int[][]grid,Queue<Integer> queue) {
        int nextX,nextY,cur,res = 0;
        while (!queue.isEmpty()) {
            cur = queue.remove();
            res++;
            for (int i = 0; i < 4; i++) {
                nextX = cur/m + directions[i][0];
                nextY = cur%m + directions[i][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 0;
                    queue.add(nextX*m+nextY);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 h = new Solution3();

        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        System.out.println(h.maxAreaOfIsland(grid));
    }
}
