package LeetCode.Number_of_Operations_to_Make_Network_Connected;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    int[] fa;
    int[] rank;

    /**
     * 看了题解后 发现不需要统计每个连通子图的边数
     * 对于一个树来说 n个节点的树至少需要有n-1条边
     * 所以如果边数少于n-1 必定不能通过移动边来形成一个树 即一个连通子图
     * 如果边数够的话 在统计最少的移边操作的次数时 只要统计有几个极大连通子图的个数count即可
     * 只要返回count-1 就是最少的次数
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);

        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            union(connections[i][0],connections[i][1]);
        }
        Map<Integer,Boolean> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (fa[i] != fa[fa[i]])
                find(i);
            if (!count.containsKey(fa[i]))
                count.put(fa[i],true);
        }

        return count.size()-1;
    }

    private int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootX] = rootY;
            rank[rootY]++;
        }
        else fa[rootY] = rootX;
    }
}