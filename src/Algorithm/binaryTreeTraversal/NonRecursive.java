package Algorithm.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历的非递归实现
 */ 
public class NonRecursive {

    /**
     * 中序遍历的迭代实现
     * @param root 根节点
     * @return 返回一个节点值数组
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            // 先将根节点放入栈中，然后放入左子树的节点，由于栈的先进后出的特性，所以先出来的是左子树的节点
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                arr.add(p.getVal());
                p = p.getRight();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        NonRecursive h = new NonRecursive();

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(8);

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        List<Integer> ans = h.inOrder(root);

        System.out.println(ans);
    }
}
