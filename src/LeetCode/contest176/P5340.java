package LeetCode.contest176;

public class P5340 {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        if (grid.length == 0) return ans;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) ans++;
            }
        }
        return ans;
    }
}
