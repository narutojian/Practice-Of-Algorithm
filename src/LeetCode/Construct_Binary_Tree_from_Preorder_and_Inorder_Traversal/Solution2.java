package LeetCode.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import LeetCode.DS.TreeNode;

import java.util.HashMap;

public class Solution2 {
    HashMap<Integer,Integer> map = new HashMap<>();// 提高在inorder中查找root的速度

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return getRoot(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode getRoot(int[] preorder,int[] inorder,int preLeft,int preRight,int inLeft,int inRight) {
        if (preLeft > preRight)
            return null;
        // preorder[preLeft]为root的值
        int inRootIndex = map.get(preorder[preLeft]);

        TreeNode root = new TreeNode(preorder[preLeft]);

        root.left = getRoot(preorder,inorder,preLeft+1,preLeft+inRootIndex-inLeft,inLeft,inRootIndex-1);
        root.right = getRoot(preorder,inorder,preLeft+inRootIndex-inLeft+1,preRight,inRootIndex+1,inRight);
        return root;
    }
}
