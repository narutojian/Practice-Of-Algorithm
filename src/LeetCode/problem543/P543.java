package LeetCode.problem543;

public class P543 {
    int ans = Integer.MIN_VALUE;

    /**
     * dfs
     * 要算直径，就算根节点的左边最长的节点和右边最长的节点两个点的长度
     * @param root 根节点
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private int dfs(TreeNode node) {
        // 叶子节点没有长度
        if (node.left == null && node.right == null) return 0;

        int leftLength = 0,rightLength = 0;
        if (node.left != null) leftLength = 1+dfs(node.left);
        if (node.right != null) rightLength = 1+dfs(node.right);
        ans = Math.max(ans,leftLength+rightLength);
        return leftLength > rightLength ? leftLength : rightLength;
    }
}
