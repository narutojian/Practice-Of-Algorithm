package LeetCode.Delete_Node_in_a_BST;

import LeetCode.DS.TreeNode;

/**
 * 450. Delete Node in a BST
 */
public class Solution {

    /**
     * 定义 删除指定的值的节点 并返回根节点
     * @param root 根节点
     * @param key 要删除的节点的值
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key) {
            // 1. 该节点为叶子节点
            if (root.left == null && root.right == null)
                return null;
            // 2. 有一个子树
            else if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
            // 3. 有两颗子树
            else {
                // 找出左子树的中序序列下的最后一个元素 作为新的根节点
                TreeNode node = findLast(root.left);
                TreeNode newRoot = new TreeNode(node.val);// 新的根节点
                newRoot.left = deleteNode(root.left,node.val);// 在左子树中删除node节点
                newRoot.right = root.right;

                return newRoot;
            }
        }
        else {
            root.left = deleteNode(root.left,key);
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    /**
     * 定义 返回中序遍历下最后一个节点
     * @param root
     * @return
     */
    private TreeNode findLast(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        TreeNode last;
        if (root.right != null)
            last = findLast(root.right);
        else {
            last = root;
        }
        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int key = 3;
        System.out.println(solution.findLast(root).val);
    }
}
