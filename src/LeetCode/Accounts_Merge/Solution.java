package LeetCode.Accounts_Merge;

import java.util.*;

/**
 * 721. Accounts Merge
 */
public class Solution {
    /**
     * 并查集
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 建立并查集
        DisjointUnionSet dsu = new DisjointUnionSet(accounts);
        int root;
        for (int i = 1; i < dsu.n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                root = dsu.stringMap.get(accounts.get(i).get(j));
                dsu.union(root,i);
            }
        }
        // 建立同一个账户下与所有邮箱的映射
        // 把邮箱存入单调队列中
        Map<Integer, PriorityQueue<String>> map = new HashMap<>();
        for (String i : dsu.stringMap.keySet()) {
            root = dsu.find(dsu.stringMap.get(i));
            if (!map.containsKey(root)) {
                PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                map.put(root,queue);
            }
            map.get(root).add(i);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i : map.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            while (!map.get(i).isEmpty()) {
                temp.add(map.get(i).remove());
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("kin","mary@mail.com","john00@mail.com"));

        List<List<String>> ans = solution.accountsMerge(accounts);

        for (List<String> i : ans) {
            System.out.println(i);
        }
    }
}
class DisjointUnionSet {
    Map<String,Integer> stringMap = new HashMap<>();// 建立邮箱与账户索引的映射
    int[] fa;
    int[] rank;
    int n;

    public DisjointUnionSet(List<List<String>> accounts) {
        this.n = accounts.size();
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!stringMap.containsKey(accounts.get(i).get(j)))
                    stringMap.put(accounts.get(i).get(j),i);
            }
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

        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootY] = rootX;
            rank[rootX]++;
        }
        else {
            fa[rootY] = rootX;
        }
    }
}