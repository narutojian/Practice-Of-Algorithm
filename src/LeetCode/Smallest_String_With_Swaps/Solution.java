package LeetCode.Smallest_String_With_Swaps;

import java.util.*;

/**
 * 1202. Smallest String With Swaps
 */
public class Solution {
    // 即表示连通子图的个数
    // 也表示当前dfs遍历的是第几个连通子图
    int round = 0;
    // 单调队列 按顺序存储字符
    PriorityQueue<Character> queue;

    /**
     * 这里用的是dfs
     * 官方题解中推荐使用并查集
     * 并查集的效率高很多
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        // 用来存储结果的字符数组
        char[] chars = new char[n];
        // 使用邻接表建立图
        Graph graph = new Graph(n);
        for (int i = 0; i < pairs.size(); i++) {
            int first = pairs.get(i).get(0);
            int sec = pairs.get(i).get(1);
            Edges firstEdge = new Edges(first,null);
            Edges secEdge = new Edges(sec,null);
            graph.vertices[first].first = insertNode(graph.vertices[first].first,secEdge);
            graph.vertices[sec].first = insertNode(graph.vertices[sec].first,firstEdge);
        }
        queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        // dfs 搜索所有连通子图 并将同一个连通子图的字母排序后依次填入字符数组中
        for (int i = 0; i < n; i++) {
            // 已访问的节点
            if (graph.vertices[i].round != 0) continue;
            round++;
            graph.vertices[i].round = round;
            queue.add(s.charAt(i));
            dfs(i,round,graph,s);
            for (int j = i; j < n && queue.size() > 0; j++) {
                if (graph.vertices[j].round == round) {
                    chars[j] = queue.remove();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * dfs
     * @param start
     * @param round
     * @param graph
     * @param s
     */
    private void dfs(int start,int round,Graph graph,String s) {
        Edges cur = graph.vertices[start].first;

        while (cur != null) {
            // 相连的点且没有访问过
            if (graph.vertices[cur.to].round == 0) {
                graph.vertices[cur.to].round = round;// 标记在哪个连通子图
                queue.add(s.charAt(cur.to));// 存放字符
                dfs(cur.to,round,graph,s);
            }
            cur = cur.next;
        }
    }

    /**
     * 链表尾插法 无头节点
     * @param first 首节点
     * @param insert 待插入节点
     * @return 返回首节点的指针
     */
    private Edges insertNode(Edges first, Edges insert) {
        // 创建一个头节点
        Edges head = new Edges(0,null);
        head.next = first;

        Edges prev = head;
        Edges cur = head.next;

        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = insert;

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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

        String ans = solution.smallestStringWithSwaps(s,pairs);

        System.out.println(ans);
    }
}
