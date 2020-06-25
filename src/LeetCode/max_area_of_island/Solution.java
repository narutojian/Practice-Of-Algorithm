package LeetCode.max_area_of_island;

public class Solution {
    private int n;
    private int m;
    private Integer temp;

    /**
     * dfs 遍历
     * 时间复杂度
     * 空间复杂度 O(nm) 01矩阵的行数和列数
     * @param grid 01矩阵
     * @return 最大陆地面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = 0;
                dfs(grid,visited,i,j);
                res = Math.max(res,temp);
            }
        }
        return res;
    }

    private void dfs(int[][] grid,boolean[][] visited,int curX,int curY) {
        if (curX < 0 || curX >= n || curY < 0 || curY >= m || grid[curX][curY] == 0 || visited[curX][curY]) {
            return;
        }
        temp += 1;
        visited[curX][curY] = true;
        dfs(grid,visited,curX-1,curY);
        dfs(grid,visited,curX,curY+1);
        dfs(grid,visited,curX+1,curY);
        dfs(grid,visited,curX,curY-1);
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        System.out.println(h.maxAreaOfIsland(grid));
    }
}
