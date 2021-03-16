package LeetCode.Kth_Smallest_Element_in_a_BST;

import LeetCode.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<Integer> memo;// 存储中序遍历序列
    int n;// 全局遍历 为k的副本

    public int kthSmallest(TreeNode root, int k) {
        memo = new ArrayList<>();
        n = k;
        inTraverse(root);
        return memo.get(n-1);
    }

    /**
     * 中序遍历
     * @param root
     */
    private void inTraverse(TreeNode root) {
        if (root == null)
            return;
        inTraverse(root.left);
        memo.add(root.val);
        // 列表已经有n个数了 达成目标
        if (memo.size() == n)
            return;
        inTraverse(root.right);
    }
}
