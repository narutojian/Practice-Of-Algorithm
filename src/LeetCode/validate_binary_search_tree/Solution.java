package LeetCode.validate_binary_search_tree;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 */
public class Solution {

    /**
     * 中序遍历 迭代实现
     * @param root 根节点
     * @return 是否为二叉查找树
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        int cur;
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (prev == null) prev = p.val;
                else {
                    cur = p.val;
                    if (cur <= prev) return false;
                    prev = cur;
                }
                p = p.right;
            }
        }
        return true;
    }
}
