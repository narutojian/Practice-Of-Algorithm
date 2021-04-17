package LeetCode.Count_Complete_Tree_Nodes;

import LeetCode.DS.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 */
public class Solution {

    public int countNodes(TreeNode root) {
        return countNodes(root,0);
    }

    private int countNodes(TreeNode root,int res) {
        if (root == null)
            return res;
        return 1+countNodes(root.left,res)+countNodes(root.right,res);
    }
}
