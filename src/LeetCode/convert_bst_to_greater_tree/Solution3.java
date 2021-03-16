package LeetCode.convert_bst_to_greater_tree;

import LeetCode.DS.TreeNode;

public class Solution3 {

    /**
     * 递归优化 不使用全局变量
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        computeKey(root,0);
        return root;
    }

    private int computeKey(TreeNode root,int preSum) {
        if (root == null)
            return preSum;

        root.val += computeKey(root.right,preSum);
        return computeKey(root.left,root.val);
    }
}
