package LeetCode.Invert_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution2 {

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
