package LeetCode.problem221;

import java.util.LinkedList;
import java.util.Queue;

public class P221 {
    private int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
    private int[][] add = {{1,0},{1,0},{0,1},{0,1}};
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                if (visit[i][j]) continue;
                ans = Math.max(ans,bfs(matrix,visit,m,n,new Node(i,j)));
            }
        }

        return ans*ans;
    }

    private int bfs(char[][] matrix, boolean[][] visit, int m, int n, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int h = 1,v = 1; // h 水平 v 垂直
        int nextX,nextY;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            for (int i = 0; i < 4; i++) {
                nextX = cur.getX()+directions[i][0];
                nextY = cur.getY()+directions[i][1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] == '1' && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    Node nextNode = new Node(nextX,nextY);
                    nextNode.setH(cur.getH()+add[i][0]);
                    nextNode.setV(cur.getV()+add[i][1]);
                    h = Math.max(h,nextNode.getH());
                    v = Math.max(v,nextNode.getV());
                    queue.add(nextNode);
                }
            }
        }

        return Math.min(h,v);
    }

    public static void main(String[] args) {
        P221 h = new P221();

//        char[][] matrix = {{'1','1'},{'1','1'}};

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        System.out.println(h.maximalSquare(matrix));
    }
}
