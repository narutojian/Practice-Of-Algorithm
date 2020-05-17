package LeetCode.subtree_of_another_tree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DFS 串匹配
 * 自己写正则表达式匹配
 */
public class Solution3 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sTree = new StringBuilder();
        StringBuilder tTree = new StringBuilder();
        preOrder(s,sTree);
        preOrder(t,tTree);
        String regex = tTree.charAt(0) == '-' ? "-\\b"+tTree.substring(1) : "\\b"+tTree.substring(0);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTree);
        return m.find();
    }

    private void preOrder(TreeNode treeNode,StringBuilder builder) {
        if (treeNode == null) {
            builder.append("s ");
            return;
        }
        builder.append(treeNode.val).append(" ");
        preOrder(treeNode.left,builder);
        preOrder(treeNode.right,builder);
    }

    public static void main(String[] args) {
        Solution3 h = new Solution3();

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);

        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);

//        TreeNode s = new TreeNode(12);
//        TreeNode t = new TreeNode(2);

//        TreeNode s = new TreeNode(4);
//        TreeNode s1 = new TreeNode(1);
//        TreeNode s2 = new TreeNode(2);
//        s.left = s1;
//        s.right = s2;
//
//        TreeNode t = new TreeNode(4);
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        t.left = t1;
//        t.right = t2;

        System.out.println(h.isSubtree(s,t));
    }
}
