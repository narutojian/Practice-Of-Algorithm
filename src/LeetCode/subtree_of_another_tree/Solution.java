package LeetCode.subtree_of_another_tree;

/**
 * 572. Subtree of Another Tree
 */
public class Solution {

    /**
     * DFS 暴力匹配
     * @param s 树 s
     * @param t 树 t
     * @return s是否包含t
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 递归的终止条件
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
//        if (isSameTree(s,t)) return true;
//        return isSubtree(s.left,t) || isSubtree(s.right,t);
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);

        TreeNode t = new TreeNode(2);

        System.out.println(h.isSubtree(s,t));
    }
}
