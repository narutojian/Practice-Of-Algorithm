package LeetCode.problem200;

public class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m*n];
        rank = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i*n+j] = i*n+j;
                    ++count;
                }
                rank[i*n+j] = 0;
            }
        }
    }

    public int find(int x) {
//        if (parent[x] != x) parent[x] = find(parent[x]);
//        return parent[x];
        while (x != parent[x]) x = parent[x];
        return x;
    }

    public void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
            else {
                parent[rootX] = rootY;
                if (rank[rootX] == rank[rootY]) rank[rootY] ++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
