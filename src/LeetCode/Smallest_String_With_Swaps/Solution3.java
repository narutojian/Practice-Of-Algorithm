package LeetCode.Smallest_String_With_Swaps;

import java.util.*;

public class Solution3 {
    int[] set;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        makeSet(n);
        char[] chars = new char[n];// 存最终结果的
        // 构建并查集
        for (int i = 0; i < pairs.size(); i++) {
            union(pairs.get(i).get(0),pairs.get(i).get(1));
        }
        // 单调队列 顺序存储索引
        PriorityQueue<Integer> indexQueue = new PriorityQueue<>();
        // 单调队列 顺序存储字符
        PriorityQueue<Character> charQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });

        // 所有的节点与根节点都是父子关系
        for (int i = 0; i < n; i++) {
            if (set[i] != set[set[i]]) {
                find(i);
            }
        }

        int root = -1;// 当前根节点
        for (int i = 0; i < n; i++) {
            // set[i] = -1表示已访问过的点
            if (set[i] == -1) continue;
            if (root == -1) root = set[i];// 下一轮

            for (int j = i; j < n; j++) {
                if (set[j] == root) {
                    set[j] = -1;
                    indexQueue.add(j);
                    charQueue.add(s.charAt(j));
                }
            }

            while (!indexQueue.isEmpty()) {
                chars[indexQueue.remove()] = charQueue.remove();
            }
            // 到下一个连通子图
            root = -1;
        }
        // 构建结果字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * 构建初始并查集 默认set[i] = i 表示自身为树的根节点或为代表
     * @param n
     */
    private void makeSet(int n) {
        set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;// 起始 父节点为本身
        }
    }

    /**
     * 找出i的根节点
     * 使用优化 路径压缩
     * @param i
     * @return
     */
    private int find(int i) {
        if (set[i] != i) {
            set[i] = find(set[i]);
        }
        return set[i];
    }

    /**
     * 合并 两个集合
     * @param x
     * @param y
     */
    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        set[rootX] = rootY;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        // test1
//        String s = "dcab";
//        List<List<Integer>> pairs = new LinkedList<>();
//        pairs.add(Arrays.asList(0,3));
//        pairs.add(Arrays.asList(1,2));
        // test2
        String s = "dcab";
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,2));
        // test3
//        String s = "cba";
//        List<List<Integer>> pairs = new LinkedList<>();
//        pairs.add(Arrays.asList(0,1));
//        pairs.add(Arrays.asList(1,2));

        String ans = solution3.smallestStringWithSwaps(s,pairs);
        System.out.println(ans);
    }
}
