package LeetCode.Surrounded_Regions;

/**
 * 130. Surrounded Regions
 */
public class Solution {
    private int m;
    private int n;
    private int[] fa;

    /**
     * 并查集 判断连通区域
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        fa = new int[m*n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i*n+j;
                if (board[i][j] == 'X') {
                    fa[x] = -1;
                    //System.out.println(i+" 行"+j + " 列为X");
                    continue;
                }
                //System.out.println(i+" 行"+j+" 列为'O'");
                fa[x] = x;
                int y;
                // 上边
                if (i-1 >= 0 && board[i-1][j] == 'O') {
                    y = x-n;
                    //System.out.println("union "+x+" and "+ y);
                    union(x,y);
                }
                // 左边
                if (j-1 >= 0 && board[i][j-1] == 'O') {
                    y = x-1;
                    //System.out.println("union "+x+" and "+ y);
                    union(x,y);
                }
            }
        }
        // 修改
        for (int i = 0; i < fa.length; i++) {
            if (fa[i] == -1)
                continue;
            int root = find(i);
            int row = root/n;
            int col = root%n;
            if (row != 0 && row != m-1 && col != 0 && col != n-1) {
                board[i/n][i%n] = 'X';
                //System.out.println(i/n+" 行"+(i%n)+" 列 改变");
            }
        }
    }

    private int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;
        int rowX = rootX/n;
        int colX = rootX%n;
        if (rowX == 0 || rowX == m-1 || colX == 0 || colX == n-1) {
            fa[rootY] = rootX;
        }
        else fa[rootX] = rootY;
    }
}
