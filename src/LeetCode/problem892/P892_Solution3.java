package LeetCode.problem892;

public class P892_Solution3 {

    /**
     * 枚举
     * 此时去除重复面积只要从上边和左边两个方向进行查询去重
     * @param grid 网格
     * @return 表面积
     */
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                ans += grid[i][j]*6 - (grid[i][j]-1)*2;
                // 去除这个单元格的上边重合面积，以及上边单元格的下边重合面积
                if (i > 0) {
                    ans -= 2*Math.min(grid[i][j],grid[i-1][j]);
                }
                // 去除这个单元格的左边重合面积，以及左边单元格的右边重合面积
                if (j > 0) {
                    ans -= 2*Math.min(grid[i][j-1],grid[i][j]);
                }
            }
        }
        return ans;
    }
}
