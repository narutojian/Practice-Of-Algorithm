package LeetCode.problem200;

import java.util.LinkedList;
import java.util.Queue;

public class P200 {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        boolean[][] visit = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    queue.add(new Node(i,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (visit[cur.getX()][cur.getY()]) continue;
            ans++;
            bfs(cur,m,n,grid,visit);
        }
        return ans;
    }

    private void bfs(Node start,int m,int n,char[][] gird, boolean[][] visit) {
        Queue<Node> queue = new LinkedList<>();
        visit[start.getX()][start.getY()] = true;
        queue.add(start);

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};// 上下左右
        int nextX,nextY;
        while (!queue.isEmpty()) {

            Node cur = queue.remove();

            for (int i = 0; i < 4; i++) {
                nextX = cur.getX()+directions[i][0];
                nextY = cur.getY()+directions[i][1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visit[nextX][nextY] && gird[nextX][nextY] != '0') {
                    visit[nextX][nextY] = true;
                    queue.add(new Node(nextX,nextY));
                }
            }
        }
    }
}
