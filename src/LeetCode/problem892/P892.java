package LeetCode.problem892;

import java.util.PriorityQueue;

public class P892 {

    /**
     * 将网格的一个单元格作为一个node，然后按照这个node立方体数量
     * 升序的存放到优先队列中
     * 然后从优先队列中先出队立方体数量最少的那个node
     * 从这个node的四个方向进行去除重合的表面积
     * 最终返回结果
     * @param grid 网格
     * @return 表面积
     */
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                Node node = new Node(i, j, grid[i][j]);
                ans += grid[i][j]*6 - (grid[i][j]-1)*2;
                queue.add(node);
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int nextX,nextY;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                nextX = cur.getX()+directions[i][0];
                nextY = cur.getY()+directions[i][1];
                if (nextX >=0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY] && grid[nextX][nextY] != 0) {
                    ans -= cur.getV()*2;
                }
            }
            visit[cur.getX()][cur.getY()] = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        P892 h = new P892();
        int[][] grid = {{1,2},{3,4}};

        System.out.println(h.surfaceArea(grid));
    }
}
