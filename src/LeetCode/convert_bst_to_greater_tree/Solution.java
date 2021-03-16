package LeetCode.convert_bst_to_greater_tree;

import LeetCode.DS.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 */
public class Solution {
    int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        computeKey(root);
        return root;
    }


    /**
     * 右 根 左 遍历
     * @param root 根节点
     */
    private void computeKey(TreeNode root) {
        if (root == null)
            return;

        computeKey(root.right);
        root.val += preSum;
        preSum = root.val;
        computeKey(root.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        System.out.println(solution.convertBST(root));
    }
}
