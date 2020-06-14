package LeetCode.problem1162;

import java.util.LinkedList;
import java.util.Queue;

public class P1162 {
    private int ans = 0;
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<WaterNode> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    WaterNode node = new WaterNode(i, j);
                    queue.add(node);
                }
            }
        }
        if (queue.size() == 0 || queue.size() == n*n) return -1;

        while (!queue.isEmpty()) {
            ans = Math.max(ans,getMaxDistance(queue.remove(),n,grid));
        }
        return ans;
    }

    private int getMaxDistance(WaterNode node,int n,int[][] grid) {
        boolean[][] visit = new boolean[n][n];
        Queue<WaterNode> queue = new LinkedList<>();
        queue.add(node);
        visit[node.getX()][node.getY()] = true;

        int x,y,nextX,nextY;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            WaterNode cur = queue.remove();
            x = cur.getX();
            y = cur.getY();
            if (grid[x][y] == 1) return Math.abs(x-node.getX())+Math.abs(y-node.getY());
            for (int i = 0; i < 4; i++) {
                nextX = x+directions[i][0];
                nextY = y+directions[i][1];
                if (nextX>=0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY]) {
                    WaterNode nextNode = new WaterNode(nextX, nextY);
                    queue.add(nextNode);
                    visit[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }
}
