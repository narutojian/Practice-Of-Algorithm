package LeetCode.validate_binary_search_tree;

import LeetCode.DS.TreeNode;

public class Solution2 {

    Integer pre = null;

    /**
     * 递归优化
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (pre != null && root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
