package LeetCode.Swim_in_Rising_Water;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water
 */
public class Solution {
    int[] fa;
    int[] rank;

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Edges> queue = new PriorityQueue<>(new Comparator<Edges>() {
            @Override
            public int compare(Edges o1, Edges o2) {
                return o1.cost-o2.cost;
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curIndex = i*n+j;
                // 右边的边
                if (j != n-1) {
                    queue.add(new Edges(curIndex,curIndex+1,Math.max(grid[i][j],grid[i][j+1])));
                }
                // 上边的边
                if (i != 0) {
                    queue.add(new Edges(curIndex,(i-1)*n+j,Math.max(grid[i][j],grid[i-1][j])));
                }
            }
        }
        // 并查集
        makeSet(n*n);

        while (!queue.isEmpty()) {
            Edges curEdge = queue.remove();
            union(curEdge.from,curEdge.to);
            if (find(0) == find(fa.length-1)) return curEdge.cost;
        }
        return -1;
    }

    private void makeSet(int n) {
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
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
        if (rootX == rootY) return;
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
        Solution solution = new Solution();

//        int[][] grid = {
//                {0,2},
//                {1,3}
//        };

        int[][] grid = {
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        };

        System.out.println(solution.swimInWater(grid));
    }
}
class Edges {
    int from;
    int to;
    int cost;

    public Edges(int from,int to,int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
