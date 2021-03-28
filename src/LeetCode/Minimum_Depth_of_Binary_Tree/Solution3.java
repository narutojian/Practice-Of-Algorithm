package LeetCode.Minimum_Depth_of_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution3 {
    private int min = Integer.MAX_VALUE;

    /**
     * dfs 剪枝优化
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root,1);
        return min;
    }

    private void helper(TreeNode root,int depth) {
        if (root == null)
            return;
        if (depth >= min)
            return;
        if (root.left == null && root.right == null)
            min = Math.min(min,depth);
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }
}
