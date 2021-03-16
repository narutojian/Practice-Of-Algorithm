package LeetCode.Insert_into_a_Binary_Search_Tree;

import LeetCode.DS.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 */
public class Solution {

    /**
     * 定义 在符合BST规则的情况插入新节点 值为val 并返回根节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }
        else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
