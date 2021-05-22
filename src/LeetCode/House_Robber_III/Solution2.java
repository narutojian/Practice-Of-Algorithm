package LeetCode.House_Robber_III;


import LeetCode.DS.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    Map<TreeNode,int[]> map = new HashMap<>();

    /**
     * dfs + 记忆化
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return Math.max(dfs(root,true),dfs(root,false));
    }

    private int dfs(TreeNode root,boolean choose) {
        if (root == null)
            return 0;
        int[] memo = map.get(root);
        if (memo == null) {
            memo = new int[2];
            Arrays.fill(memo,-1);
        }
        int index = choose ? 1 : 0;
        if (memo[index] != -1)
            return memo[index];
        if (choose)
            memo[index] = dfs(root.right,false)+dfs(root.left,false)+root.val;
        else memo[index] = Math.max(dfs(root.right,true),dfs(root.right,false))+Math.max(dfs(root.left,true),dfs(root.left,false));

        map.put(root,memo);
        return memo[index];
    }
}
