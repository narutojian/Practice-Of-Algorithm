package LeetCode.Smallest_String_With_Swaps;

import java.util.*;

public class Solution2 {

    // 单调队列 顺序存储待更新字符索引号
    PriorityQueue<Integer> indexQueue;
    // 单调队列 顺序存储待字符
    PriorityQueue<Character> charQueue;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        // 存字符
        char[] chars = new char[n];
        // 建图
        Graph graph = new Graph(n);
        for (int i = 0; i < pairs.size(); i++) {
            int first = pairs.get(i).get(0);
            int sec = pairs.get(i).get(1);
            Edges firstEdge = new Edges(first,null);
            Edges secEdge = new Edges(sec,null);
            graph.vertices[first].first = insertNode(graph.vertices[first].first,secEdge);
            graph.vertices[sec].first = insertNode(graph.vertices[sec].first,firstEdge);
        }
        indexQueue = new PriorityQueue<>();
        // 重写比较器
        charQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        // dfs 搜索所有连通子图 并将同一个连通子图的字母排序后依次填入字符数组中
        for (int i = 0; i < n; i++) {
            // 已访问的节点
            if (graph.vertices[i].round != 0) continue;
            graph.vertices[i].round = 1;
            charQueue.add(s.charAt(i));
            indexQueue.add(i);
            dfs(i,graph,s);
            while (!indexQueue.isEmpty()) {
                chars[indexQueue.remove()] = charQueue.remove();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    private void dfs(int start,Graph graph,String s) {
        Edges cur = graph.vertices[start].first;

        while (cur != null) {
            // 相连的点且没有访问过
            if (graph.vertices[cur.to].round == 0) {
                graph.vertices[cur.to].round = 1;// 标记已访问
                indexQueue.add(cur.to);// 存放索引
                charQueue.add(s.charAt(cur.to));// 存放字符
                dfs(cur.to,graph,s);
            }
            cur = cur.next;
        }
    }

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
        Solution2 solution2 = new Solution2();

//         test1
        String s = "dcab";
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));

        String ans = solution2.smallestStringWithSwaps(s,pairs);

        System.out.println(ans);
    }
}
