package LeetCode.House_Robber_III;


import LeetCode.DS.TreeNode;

/**
 * 337. House Robber III
 */
public class Solution {

    public int rob(TreeNode root) {
        return Math.max(dfs(root,true),dfs(root,false));
    }

    /**
     * 定义： 以root为根的树 所能偷盗的最大的金钱
     * @param root
     * @param choose
     * @return
     */
    private int dfs(TreeNode root,boolean choose) {
        if (root == null)
            return 0;
        // 当前节点选中
        if (choose)
            return dfs(root.right,false)+dfs(root.left,false)+root.val;
        // 当前节点未选中
        return Math.max(dfs(root.right,true),dfs(root.right,false))+Math.max(dfs(root.left,true),dfs(root.left,false));
    }
}
