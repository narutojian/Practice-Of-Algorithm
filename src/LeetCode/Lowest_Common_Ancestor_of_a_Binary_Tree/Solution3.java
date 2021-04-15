package LeetCode.Lowest_Common_Ancestor_of_a_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution3 {

    /**
     * 后序遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 说明此时 p,q一个在左子树，一个在右子树
        if ((left == p && right == q) || (left == q && right == p))
            return root;
        if (left == right)// 同一个节点 那说明是公共的父节点
            return left;
        if (left == null || right == null)// 此时说明p,q同在左子树或右子树中
            return left == null ? right : left;
        if (root.left == left && root.right == right)// 此时最近的公共祖先为root
            return root;
        return lowestCommonAncestor(root,left,right);
    }
}
