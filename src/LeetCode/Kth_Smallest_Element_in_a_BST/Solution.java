package LeetCode.Kth_Smallest_Element_in_a_BST;

import LeetCode.DS.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 230. Kth Smallest Element in a BST
 */
public class Solution {
    PriorityQueue<Integer> queue;// 大根堆

    /**
     * 暴力枚举
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        preTraverse(root,k);
        return queue.remove();
    }

    /**
     * 前序遍历
     * @param root
     * @param k
     */
    private void preTraverse(TreeNode root,int k) {
        if (root == null)
            return;
        queue.add(root.val);
        if (queue.size() > k) {
            queue.remove();
        }
        preTraverse(root.left,k);
        preTraverse(root.right,k);
    }
}
