package LeetCode.Lowest_Common_Ancestor_of_a_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution4 {

    /**
     * 定义 以root为根的树，返回一个节点
     * p，q有如下三种情况：
     * 1. 都在root中；返回最近的公共祖先节点
     * 2. 一个在，一个不在； 返回那个在的节点
     * 3. 都不在； 返回null
     *
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
        // p,q一个在root的左子树，一个在root的右子树
       if (left != null && right != null)
           return root;
       // 都不在
       if (left == null && right == null)
           return null;
       // 一个在，一个不在
       return left == null ? right : left;
    }
}
