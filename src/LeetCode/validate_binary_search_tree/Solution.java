package LeetCode.validate_binary_search_tree;

import LeetCode.DS.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
public class Solution {

    Integer pre = null;// 保存中序序列种的前一个节点的值

    /**
     * 递归
     * 定义 判断root为根节点的树是否是一个标准的BST
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean left = isValidBST(root.left);// 左子树是否满足
        boolean cur = true;// root节点的值是否大于pre
        if (pre != null)
            cur = root.val > pre;
        pre = root.val;
        boolean right = isValidBST(root.right);// 右子树是否满足

        return left && cur && right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        System.out.println(solution.isValidBST(root));
    }
}
