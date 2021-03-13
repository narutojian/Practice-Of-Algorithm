package LeetCode.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import LeetCode.DS.TreeNode;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return getRoot(postorder,0, 0,n-1);
    }

    private TreeNode getRoot(int[] postorder, int inLeft, int postLeft, int postRight) {
        if (postLeft > postRight)
            return null;
        // postorder[postRight]为root的值
        int inRootIndex = map.get(postorder[postRight]);

        TreeNode root = new TreeNode(postorder[postRight]);

        root.left = getRoot(postorder,inLeft, postLeft,inRootIndex+postLeft-inLeft-1);
        root.right = getRoot(postorder,inRootIndex+1, inRootIndex+postLeft-inLeft,postRight-1);
        return root;
    }
}
