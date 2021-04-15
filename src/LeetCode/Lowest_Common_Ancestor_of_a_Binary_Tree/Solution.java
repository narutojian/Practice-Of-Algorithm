package LeetCode.Lowest_Common_Ancestor_of_a_Binary_Tree;

import LeetCode.DS.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class Solution {

    /**
     * 定义 寻找p和q的最近的祖先节点 并返回
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (isExist(root,p,q,new boolean[2])) {
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);

            TreeNode res = left != null ? left : right;
            return res == null ? root : res;
        }
        return null;
    }

    /**
     * 定义 判断以root为根的树是否包含p和q
     * @param root
     * @param p
     * @param q
     * @param existed
     * @return
     */
    private boolean isExist(TreeNode root,TreeNode p,TreeNode q,boolean[] existed) {
        if (existed[0] && existed[1])
            return true;
        if (root == null)
            return false;
        if (root == p)
            existed[0] = true;
        if (root == q)
            existed[1] = true;
        return isExist(root.left,p,q,existed) || isExist(root.right,p,q,existed);
    }
}
