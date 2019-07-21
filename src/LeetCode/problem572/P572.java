package LeetCode.Problem572;

public class P572 {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        TreeNode temp = t;

        if (s == null && temp == null)
            return true;
        if (s == null || temp == null)
            return false;
        if (s.val == temp.val && isSameTree(s,temp))
            return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
