    package LeetCode.problem95;

import java.util.ArrayList;
import java.util.List;

public class P95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.addAll(dfs(i,1,n));
        }
        return ans;
    }

    private List<TreeNode> dfs(int root, int leftBorder, int rightBorder) {
        List<TreeNode> ans = new ArrayList<>();
        if (leftBorder == rightBorder) {// 如果左边界和右边界一样，说明只剩下一个节点，为叶节点
            ans.add(new TreeNode(root));
            return ans;
        }
        List<TreeNode> leftTree = new ArrayList<>();
        List<TreeNode> rightTree = new ArrayList<>();

        // 求左子树的所有排列情况
        for (int i = leftBorder; i < root; i++) {
            leftTree.addAll(dfs(i,leftBorder,root-1));
        }
        // 求右子树的所有排列情况
        for (int i = rightBorder; i > root; i--) {
            rightTree.addAll(dfs(i,root+1,rightBorder));
        }
        //拼接左子树 右子树和根节点
        if (leftTree.size() == 0) {
            for (int i = 0; i < rightTree.size(); i++) {
                TreeNode node = new TreeNode(root);
                node.right = rightTree.get(i);
                ans.add(node);
            }
        }
        else if (rightTree.size() == 0) {
            for (int i = 0; i < leftTree.size(); i++) {
                TreeNode node = new TreeNode(root);
                node.left = leftTree.get(i);
                ans.add(node);
            }
        }
        else {
            for (int i = 0; i < leftTree.size(); i++) {
                for (int j = 0; j < rightTree.size(); j++) {
                    TreeNode node = new TreeNode(root);
                    node.left = leftTree.get(i);
                    node.right = rightTree.get(j);
                    ans.add(node);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        P95 h = new P95();
//        int n = 1;
//        int n = 2;
        int n = 3;
//        int n = 4;
//        int n = 5;
        List<TreeNode> ans;
        ans = h.generateTrees(n);
        for (TreeNode head :
                ans) {
            System.out.println(head.val);
        }
    }
}
