package LeetCode.convert_bst_to_greater_tree;

/**
 * 538. Convert BST to Greater Tree
 */
public class Solution {
    // 全局变量 保存上一个节点的值 不能定义局部变量，即在inOrder里添加Integer pre
    // 栈不能把递归的底层的pre也保留在上层的递归中
    private int pre = 0;

    /**
     * 中序遍历 改
     * 先右，再根，后左
     * @param root 根节点
     * @return greater tree
     */
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        root.val += pre;
        pre = root.val;
        inOrder(root.left);
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;

//        root = h.convertBST(root);
    }
}
