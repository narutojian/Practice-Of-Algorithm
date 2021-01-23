package LeetCode.Number_of_Operations_to_Make_Network_Connected;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1319. Number of Operations to Make Network Connected
 */
public class Solution {

    public int makeConnected(int n, int[][] connections) {
        // 建立并查集
        DisjointUnionSet dsu = new DisjointUnionSet(n);
        for (int i = 0; i < connections.length; i++) {
            dsu.union(connections[i][0],connections[i][1]);
        }
        Map<Integer,Integer> vertices = new HashMap<>();// 记录同一个极大连通子图所包含的点的个数
        for (int i = 0; i < n; i++) {
            if (dsu.fa[i] != dsu.fa[dsu.fa[i]])
                dsu.find(i);
            if (!vertices.containsKey(dsu.fa[i])) {
                vertices.put(dsu.fa[i],1);
            }
            else vertices.put(dsu.fa[i],vertices.get(dsu.fa[i])+1);
        }

        int count = vertices.size();// 连通子图的个数
        int extra = 0;// 一个连通子图多余的边

        for (int i : vertices.keySet()) {
            if (dsu.edges.get(i) == null) continue;
            extra += dsu.edges.get(i) - vertices.get(i) + 1;
        }
        if (extra < count-1) return -1;
        else return count -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        int n = 4;
//        int[][] connections = {
//                {0,1},
//                {0,2},
//                {1,2}
//        };
        // test2
//        int n = 6;
//        int[][] connections = {
//                {0,1},
//                {0,2},
//                {0,3},
//                {1,2},
//                {1,3}
//        };
        // test3
//        int n = 6;
//        int[][] connections = {
//                {0,1},
//                {0,2},
//                {0,3},
//                {1,2}
//        };

        int n = 5;
        int[][] connections = {
                {0,1},
                {0,2},
                {3,4},
                {2,3}
        };

        System.out.println(solution.makeConnected(n,connections));
    }
}
class DisjointUnionSet {
    // 需要记录一个极大连通子图中的点的个数与边的个数
    int[] fa;
    int[] rank;
    Map<Integer,Integer> edges = new HashMap<>();// 记录同一个极大连通子图所包含的边的个数

    public DisjointUnionSet(int n) {
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);

        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    public void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            edges.put(rootX,edges.get(rootX)+1);
            return;
        }
        int edge = 1,root,son;
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
            son = rootX;
            root = rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootX] = rootY;
            rank[rootY]++;
            son = rootX;
            root = rootY;
        }
        else {
            fa[rootY] = rootX;
            son = rootY;
            root = rootX;
        }

        if (edges.containsKey(root)) {
            edge += edges.get(root);
        }
        if (edges.containsKey(son)) {
            edge += edges.get(son);
            edges.remove(son);
        }
        edges.put(root,edge);
    }
}
