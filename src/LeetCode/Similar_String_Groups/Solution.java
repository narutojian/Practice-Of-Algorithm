package LeetCode.Similar_String_Groups;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    int[] fa;

    /**
     * 并查集
     * @param strs
     * @return
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        // 建立并查集
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        int rootX,rootY;
        for (int i = 0; i < n - 1; i++) {
            rootX = find(i);
            for (int j = i+1; j < n; j++) {
                rootY = find(j);
                if (rootX == rootY) continue;
                if (checkSimilarity(strs[i],strs[j]))
                    union(rootX,rootY);
            }
        }
        // 存储根节点的个数
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    private int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        fa[y] = x;
    }

    /**
     * 检测两个字符串是否相似
     * @param str1
     * @param str2
     * @return
     */
    private boolean checkSimilarity(String str1,String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                diff++;
            if (diff > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};

        System.out.println(solution.numSimilarGroups(strs));
    }
}
