package LeetCode.problem695;

import java.util.LinkedList;
import java.util.Queue;

public class P695 {
    int ans = 0;

    /**
     * BFS
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visit = new boolean[row][column];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    Node node = new Node(i,j);
                    queue.add(node);
                }
            }
        }

        while (!queue.isEmpty() && ans < queue.size()) {
            Node node = queue.remove();
            if (visit[node.row][node.column])
                continue;
            visit[node.row][node.column] = true;
            bfs(node,row,column,grid,visit);
        }
        return ans;
    }

    private void bfs(Node node,int row,int column,int[][] grid,boolean[][] visit) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int[] directionR = {-1,1,0,0};
        int[] directionC = {0,0,-1,1};
        int num = 1;
        int curRow,curColumn,nextR,nextC;
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            curRow = curNode.row;
            curColumn = curNode.column;
            for (int i = 0; i < 4; i++) {
                nextR = curRow+directionR[i];
                nextC = curColumn+directionC[i];
                if (nextR >= 0 && nextC >= 0 && nextR < row && nextC < column && grid[nextR][nextC] == 1 && !visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    num++;
                    Node nextNode = new Node(nextR,nextC);
                    queue.add(nextNode);
                }
            }
        }
        ans = Math.max(ans,num);
    }

    public static void main(String[] args) {
        P695 h = new P695();
        int[][] gird = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        System.out.println(h.maxAreaOfIsland(gird));
    }
}
