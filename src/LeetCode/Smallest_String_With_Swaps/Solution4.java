package LeetCode.Smallest_String_With_Swaps;

import java.util.*;

public class Solution4 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSetUnion dsu = new DisjointSetUnion(s.length());
        // 构建并查集
        for (int i = 0; i < pairs.size(); i++) {
            dsu.unionSet(pairs.get(i).get(0),pairs.get(i).get(1));
        }
        // 所有节点与祖先的距离都为1
        for (int i = 0; i < dsu.n; i++) {
            if (dsu.fa[i] != dsu.fa[dsu.fa[i]])
                dsu.find(i);
        }
        // 存储同一个root的字符到一个优先队列中
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < dsu.n; i++) {
            if (!map.containsKey(dsu.fa[i])) {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                map.put(dsu.fa[i],minHeap);
            }
            map.get(dsu.fa[i]).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dsu.n; i++) {
            sb.append(map.get(dsu.fa[i]).remove());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        // test1
//        String s = "dcab";
//        List<List<Integer>> pairs = new LinkedList<>();
//        pairs.add(Arrays.asList(0,3));
//        pairs.add(Arrays.asList(1,2));
        // test2
//        String s = "dcab";
//        List<List<Integer>> pairs = new LinkedList<>();
//        pairs.add(Arrays.asList(0,3));
//        pairs.add(Arrays.asList(1,2));
//        pairs.add(Arrays.asList(0,2));
        // test3
        String s = "cba";
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(Arrays.asList(0,1));
        pairs.add(Arrays.asList(1,2));

        System.out.println(solution4.smallestStringWithSwaps(s,pairs));
    }
}

/**
 * 并查集
 */
class DisjointSetUnion {
    int n;
    int[] rank;// 深度
    int[] fa;// fa[i]:i节点的父节点

    // 初始化
    public DisjointSetUnion(int n) {
        this.n = n;
        rank = new int[n];
        Arrays.fill(rank,1);// 初始深度为1 就是本身节点构成的树
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    /**
     * 查找i节点的祖先节点
     * 优化 路径压缩
     * @param i
     * @return
     */
    public int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    /**
     * 合并两个集合
     * 优化 将高度小的树加到高度大的树上 这样形成的新的树高最小
     * 这样在之后的find操作时 递归次数变少
     * @param x
     * @param y
     */
    public void unionSet(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        // 深度相同的树 两棵树合并 深度加一
        // 这里让根为rootX的树加到根为rootY的树上
        if (rank[rootX] == rank[rootY]) {
            rank[rootY]++;
        }
        fa[rootX] = rootY;
    }
}
