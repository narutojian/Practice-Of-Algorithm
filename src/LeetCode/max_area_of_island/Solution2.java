package LeetCode.max_area_of_island;

public class Solution2 {
    private Integer cur;
    private int n;
    private int m;

    /**
     * dfs 空间优化 空间复杂度O(1)
     * @param grid 01矩阵
     * @return 最大陆地面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cur = 0;
                dfs(grid,i,j);
                ans = Math.max(ans,cur);
            }
        }
        return ans;
    }

    private void dfs(int[][] grid,int curX,int curY) {
        if (curX < 0 || curX >= n || curY < 0 || curY >= m || grid[curX][curY] == 0) {
            return;
        }
        cur += 1;
        grid[curX][curY] = 0;
        dfs(grid,curX-1,curY);
        dfs(grid,curX,curY+1);
        dfs(grid,curX+1,curY);
        dfs(grid,curX,curY-1);
    }
}
