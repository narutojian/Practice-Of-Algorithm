package LeetCode.problem199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        dfs(queue,ans);
        return ans;
    }

    private void dfs(Queue<TreeNode> queue,List<Integer> ans) {
        if (queue.isEmpty()) return;
        ans.add(queue.peek().val);

        Queue<TreeNode> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.right != null) nextQueue.add(cur.right);
            if (cur.left != null) nextQueue.add(cur.left);
        }

        dfs(nextQueue,ans);
    }
}
