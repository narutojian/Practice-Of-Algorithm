package LeetCode.problem892;

public class P892_Solution2 {

    /**
     * 枚举
     * 对于一个单元格的立方体，如何去除与其他单元格的立方体的表面积重合
     * 此方案从一个单元格的四个方向（上，下，左，右）来删除重合的表面积
     * @param grid 网格
     * @return 表面积
     */
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int nextX,nextY;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                ans += grid[i][j]*6 - (grid[i][j]-1)*2;

                for (int k = 0; k < 4; k++) {
                    nextX = i+directions[k][0];
                    nextY = j+directions[k][1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] != 0) {
                        ans -= Math.min(grid[i][j],grid[nextX][nextY]);
                    }
                }
            }
        }

        return ans;
    }
}
