package LeetCode.Satisfiability_of_Equality_Equations;

/**
 * 990. Satisfiability of Equality Equations
 */
public class Solution {
    private int[] fa;

    /**
     * 并查集
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        fa = new int[26];

        for (int i = 0; i < 26; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '=') {
                union(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
            }
        }
        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '!') {
                int rootX = find(equations[i].charAt(0)-'a');
                int rootY = find(equations[i].charAt(3)-'a');
                if (rootX == rootY)
                    return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;
        fa[rootX] = rootY;
    }
}
