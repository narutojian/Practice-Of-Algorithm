package LeetCode.Search_in_a_Binary_Search_Tree;

import LeetCode.DS.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 */
public class Solution {

    /**
     * 定义 返回值为val的节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode left = searchBST(root.left,val);
        if (left != null)
            return left;
        return searchBST(root.right,val);
    }
}
