package LeetCode.problem94;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历——递归方法
 */
public class P94 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderT(root);
        return ans;
    }

    private void inorderT(TreeNode node) {
        if (node == null) return;
        inorderT(node.left);
        ans.add(node.val);
        inorderT(node.right);
    }
}
