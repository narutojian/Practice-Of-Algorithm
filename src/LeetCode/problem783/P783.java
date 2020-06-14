package LeetCode.problem783;

public class P783 {
    int ans = Integer.MAX_VALUE;
    int[] num = new int[100];
    int index = 0;

    public int minDiffInBST(TreeNode root) {
        recursive(root);
        int temp;
        for (int i = 0; i < index-1; i++) {
            temp = num[i+1] - num[i];
            if (temp < ans)
                ans = temp;
        }
        return ans;
    }

    /**
     * 中序遍历，将树的节点值放到数组中
     * @param node
     */
    private void recursive(TreeNode node) {
        if (node == null) return;
        recursive(node.left);
        num[index++] = node.val;
        recursive(node.right);
    }
}
