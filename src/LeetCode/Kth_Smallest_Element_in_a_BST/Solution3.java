package LeetCode.Kth_Smallest_Element_in_a_BST;

import LeetCode.DS.TreeNode;

public class Solution3 {
    int n;// 全局变量 k的副本
    int res;// 全局变量 保存结果

    public int kthSmallest(TreeNode root, int k) {
        n = k;
        inTraverse(root);
        return res;
    }

    private void inTraverse(TreeNode root) {
        if (root == null || n < 1)
            return;
        inTraverse(root.left);
        // 用的是减法 n为1 那个数就是答案
        if (n == 1) {
            res = root.val;
        }
        n--;// n减1 去遍历下一个数
        inTraverse(root.right);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 1;

        System.out.println(solution3.kthSmallest(root,k));
    }
}
