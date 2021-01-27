package LeetCode.Regions_Cut_By_Slashes;

import java.util.Arrays;

public class Solution3 {
    int[] fa;
    int[] rank;
    int count = 1;// 统计环数 初始为1

    /**
     * 看的其他人的题解
     * 统计正方形内部的区域个数就是统计内部形成了几个环
     * 统计环用的方法就是在合并两个点时 如果祖先一致 那就说明形成了环
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        makeSet(n+1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (grid[i].charAt(j)) {
                    case ' ': break;
                    case '/': {
                        union(i*(n+1)+j+1,(i+1)*(n+1)+j);
                        break;
                    }
                    default: {
                        union(i*(n+1)+j,(i+1)*(n+1)+j+1);
                        break;
                    }
                }
            }
        }

        return count;
    }

    private void makeSet(int n) {
        fa = new int[n*n];
        rank = new int[n*n];
        Arrays.fill(rank,1);
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        // 正方的边界的点是连通的
        for (int i = 0,j = (n-1)*n; i < n && j < n*n; i++,j++) {
            fa[i] = 0;
            fa[j] = 0;
        }
        for (int i = 0,j = n-1; i < (n-1)*n+1 && j < n*n; i += n,j += n) {
            fa[i] = 0;
            fa[j] = 0;
        }
        rank[0] = 2;
    }

    private int find(int x) {
        if (x != fa[x])
            fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);

        // 形成了环
        if (rootX == rootY) {
            count++;
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootY] = rootX;
            rank[rootX]++;
        }
        else fa[rootY] = rootX;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        String[] grid = {" /", "/ "};

//        String[] grid = {"/"};

//        String[] grid = {" /","  "};

//        String[] grid = {"\\/","/\\"};

//        String[] grid = {"/\\","\\/"};

//        String[] grid = {"//","/ "};

        System.out.println(solution3.regionsBySlashes(grid));
    }
}
