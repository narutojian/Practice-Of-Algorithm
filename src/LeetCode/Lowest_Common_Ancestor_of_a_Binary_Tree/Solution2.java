package LeetCode.Lowest_Common_Ancestor_of_a_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution2 {

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

        if (isExist(root.left,p) && isExist(root.left,q)) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if (isExist(root.right,p) && isExist(root.right,q)) {
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }

    private boolean isExist(TreeNode root,TreeNode target) {
        if (root == null)
            return false;
        if (root.val == target.val)
            return true;
        return isExist(root.left,target) || isExist(root.right,target);
    }
}
