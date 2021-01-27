package LeetCode.Regions_Cut_By_Slashes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 959. Regions Cut By Slashes
 */
public class Solution {
    /**
     * 并查集
     * 判断正方形区域有几个环
     * 我自己想的思路是判断每个极大连通子图中的点数与边数的差异
     * 一个极大连通子图的内部环数 = 边数-(点数-1);// 点数-1 是形成连通图的最少的边数
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DisjointUnionSet dsu = new DisjointUnionSet(n+1);
        char curChar;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                curChar = grid[i].charAt(j);
                if (curChar == ' ') continue;
                if (curChar == '\\') {
                    dsu.union(i*(n+1)+j,(i+1)*(n+1)+j+1);
                }
                else dsu.union(i*(n+1)+j+1,(i+1)*(n+1)+j);
            }
        }
        Map<Integer,Integer> vertexMap = new HashMap<>();
        for (int i = 0; i < dsu.fa.length; i++) {
            if (dsu.fa[i] != dsu.fa[dsu.fa[i]])
                dsu.find(i);
            vertexMap.put(dsu.fa[i],vertexMap.getOrDefault(dsu.fa[i],0)+1);
        }
        int res = 0;

        for (int i : vertexMap.keySet()) {
            if (vertexMap.get(i) == 1) continue;

            res += dsu.edgeMap.get(i) - vertexMap.get(i) +1;
        }

        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

//        String[] grid = {" /", "/ "};

//        String[] grid = {"/"};

//        String[] grid = {" /","  "};

//        String[] grid = {"\\/","/\\"};

//        String[] grid = {"/\\","\\/"};

        String[] grid = {"//","/ "};

        System.out.println(solution.regionsBySlashes(grid));
    }
}

class DisjointUnionSet {
    int[] fa;
    int[] rank;
    Map<Integer,Integer> edgeMap = new HashMap<>();

    public DisjointUnionSet(int n) {
        fa = new int[n*n];
        rank = new int[n*n];

        Arrays.fill(rank,1);

        for (int i = 0; i < n * n; i++) {
            fa[i] = i;
        }
        // 初始的边
        for (int i = 0,j = (n-1)*n; i < n && j < n*n; i++,j++) {
            fa[i] = 0;
            fa[j] = 0;
        }
        for (int i = 0,j = n-1; i < (n-1)*n+1 && j < n*n; i += n,j += n) {
            fa[i] = 0;
            fa[j] = 0;
        }
        rank[0] = 2;
        edgeMap.put(0,(n-1)*4);
    }

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    public void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        int root,son;
        if (rootX == rootY) {
            edgeMap.put(rootX,edgeMap.get(rootX)+1);
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
            root = rootY;
            son = rootX;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootY] = rootX;
            rank[rootX]++;
            root = rootX;
            son = rootY;
        }
        else {
            fa[rootY] = rootX;
            root = rootX;
            son = rootY;
        }
        edgeMap.put(root,edgeMap.getOrDefault(root,0)+edgeMap.getOrDefault(son,0)+1);
    }
}