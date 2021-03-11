package LeetCode.Invert_Binary_Tree;

/**
 * 226. Invert Binary Tree
 */
public class Solution {

    /**
     * 递归 二叉树前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        // 翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
