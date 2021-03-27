package LeetCode.Minimum_Depth_of_Binary_Tree;

import LeetCode.DS.TreeNode;

public class Solution2 {

    /**
     * 定义 返回以root为根节点的树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right)+1;
        if (root.right == null)
            return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
