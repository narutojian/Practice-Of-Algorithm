package LeetCode.Count_Complete_Tree_Nodes;

import LeetCode.DS.TreeNode;

public class Solution2 {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
