package LeetCode.convert_bst_to_greater_tree;

import LeetCode.DS.TreeNode;

public class Solution2 {
    int preSum = 0;

    /**
     * 递归优化
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }
}
