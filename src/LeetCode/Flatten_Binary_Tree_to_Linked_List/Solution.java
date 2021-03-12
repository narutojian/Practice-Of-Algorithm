package LeetCode.Flatten_Binary_Tree_to_Linked_List;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class Solution {
    TreeNode last;// 存储root根节点下 左子树拉成链表后的最后一个节点

    /**
     * 前序遍历 递归
     * flatten函数的定义 给定一个根节点root 将root的左子树和右子树拉成一个链表 并将原先的左子树变为root的右子树
     * 原先的右子树连到原先左子树的最后一个节点上
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            last = root == null ? last : root;// last为左子树的最右节点 若无右节点 则为最左节点
            return;
        }
        TreeNode originRight = root.right;// 原先的右子树的位置
        if (root.left != null) {
            root.right = root.left;// 原先的左子树变为右子树
            root.left = null; // 左子树置空
            flatten(root.right);// 把原先的左子树拉成一个链表
            last.right = originRight;// 原先左子树的最后一个节点为原先右子树的前驱节点
        }
        flatten(originRight);// 把原先的右子树拉成一个链表
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        solution.flatten(root);

        while (root != null) {
            System.out.print(root.val+" ");
            root = root.right;
        }
    }
}
