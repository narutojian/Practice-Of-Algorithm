package LeetCode.problem200;

public class P200_UnionFind {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';

                    // 查找该节点的周围，如果是同类则合并
                    if (r-1 >= 0 && grid[r-1][c] == '1') {
                        unionFind.union(r*nc+c,(r-1)*nc+c);
                    }
                    if (r+1 < nr && grid[r+1][c] == '1') {
                        unionFind.union(r*nc+c,(r+1)*nc+c);
                    }
                    if (c-1 >= 0 && grid[r][c-1] == '1') {
                        unionFind.union(r*nc+c,r*nc+c-1);
                    }
                    if (c+1 < nc && grid[r][c+1] == '1') {
                        unionFind.union(r*nc+c,r*nc+c+1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    public static void main(String[] args) {
        P200_UnionFind h = new P200_UnionFind();

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

        System.out.println(h.numIslands(grid));
    }
}
