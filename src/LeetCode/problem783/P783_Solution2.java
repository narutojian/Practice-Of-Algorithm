package LeetCode.problem783;

public class P783_Solution2 {
    Integer ans,prev;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    /**
     * 中序遍历，保存树节点的前面一个值和当前值，两个值的差与ans进行对比
     * @param node
     */
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans,node.val - prev);
        prev = node.val;
        dfs(node.right);
//        if (node.right != null)
//            ans = Math.min(ans,node.val - prev);
    }

    public static void main(String[] args) {
        P783_Solution2 h = new P783_Solution2();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(h.minDiffInBST(node1));
    }
}
