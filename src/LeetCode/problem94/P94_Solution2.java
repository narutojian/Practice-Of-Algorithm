package LeetCode.problem94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  中序遍历——迭代方法
 */
public class P94_Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            // 先把左子树的节点压入栈
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            ans.add(curNode.val);
            // 开始加入右子树
            curNode = curNode.right;
        }
        return ans;
    }
}
