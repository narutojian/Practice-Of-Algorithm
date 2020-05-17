package LeetCode.subtree_of_another_tree;

/**
 * DFS 串匹配
 * string contains API
 */
public class Solution2 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder tTree = new StringBuilder(" ");
        StringBuilder sTree = new StringBuilder(" ");
        preOrder(t,tTree);
        preOrder(s,sTree);
        return sTree.toString().contains(tTree);
    }

    private void preOrder(TreeNode treeNode,StringBuilder builder) {
        if (treeNode == null) {
            builder.append("null ");
            return;
        }
        builder.append(treeNode.val).append(" ");
        preOrder(treeNode.left,builder);
        preOrder(treeNode.right,builder);
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        TreeNode s = new TreeNode(12);
//        TreeNode s1 = new TreeNode(2);
//        s.left = s1;

        TreeNode t = new TreeNode(2);

        System.out.println(h.isSubtree(s,t));
    }
}
