package LeetCode.Binary_Search_Tree_to_Greater_Sum_Tree;

import LeetCode.DS.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 */
public class Solution {

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        computeKey(root,0);
        return root;
    }

    private int computeKey(TreeNode root,int preSum) {
        if (root == null)
            return preSum;
        root.val += computeKey(root.right,preSum);
        return computeKey(root.left,root.val);
    }
}
