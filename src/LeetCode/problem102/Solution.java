package LeetCode.problem102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        dfs(queue);
        return ans;
    }

    private void dfs(Queue<TreeNode> queue) {
        if (queue.isEmpty()) return;
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            list.add(cur.val);
            if (cur.left != null) next.add(cur.left);
            if (cur.right != null) next.add(cur.right);
        }
        ans.add(list);
        dfs(next);
    }
}
