package LeetCode.validate_binary_search_tree;

public class Solution2 {
    private Integer pre = null;

    /**
     * 中序遍历 递归实现
     * @param root 根节点
     * @return 是否为二叉查找树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问右子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 根节点和左子树节点比较
        if (pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
        /* return inOrder(root); */
    }

/*
    private boolean inOrder(TreeNode node) {
        if (node == null) return true;
        if (!inOrder(node.left)) return false;
        if (pre != null && node.val <= pre) return false;
        pre = node.val;
        return inOrder(node.right);
    }
*/

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        TreeNode t0 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;

        System.out.println(h.isValidBST(t0));
    }
}
