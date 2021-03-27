package LeetCode.Minimum_Depth_of_Binary_Tree;

import LeetCode.DS.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class Solution {

    /**
     * bfs
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()) {
            res++;
            int num = deque.size();
            while (num > 0) {
                TreeNode cur = deque.remove();
                if (cur.left == null && cur.right == null)
                    return res;
                if (cur.left != null)
                    deque.add(cur.left);
                if (cur.right != null)
                    deque.add(cur.right);
                num--;
            }
        }
        return res;
    }
}
