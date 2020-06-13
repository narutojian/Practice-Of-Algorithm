package LeetCode.$01_matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 */
public class Solution {

    /**
     * BFS，将所有的0作为一个整体，即为一个点进行BFS搜索所有的1并计算距离
     * @param matrix 01矩阵
     * @return 距离矩阵
     */
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Node(i,j));
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int nextX,nextY;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            for (int i = 0; i < 4; i++) {
                nextX = cur.getX()+directions[i][0];
                nextY = cur.getY()+directions[i][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    matrix[nextX][nextY] = 1+matrix[cur.getX()][cur.getY()];
                    queue.add(new Node(nextX,nextY));
                }
            }
        }
        return matrix;
    }
}
