package LeetCode.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import LeetCode.DS.TreeNode;

/**
 *
 */
public class Solution {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRoot(0,inorder.length,preorder,inorder);
    }

    /**
     * 定义 preorder[preIndex]作为根节点 inorder的[left,right)表示当前树的所有节点（包括根节点）
     * 返回当前树的根节点
     * @param left 中序的左边界（闭区间）
     * @param right 中序的右边界（开区间）
     * @param preorder 前序
     * @param inorder 中序
     * @return 根节点
     */
    private TreeNode getRoot(int left,int right,int[] preorder,int[] inorder) {
        if (left == right)  {
            preIndex--;
            return null;
        }
        // 寻找当前根节点在inorder中的位置
        int rootIndex = -1;
        for (int i = left; i < right; i++) {
            if (inorder[i] == preorder[preIndex]) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = getRoot(left,rootIndex,preorder,inorder);
        preIndex++;
        root.right = getRoot(rootIndex+1,right,preorder,inorder);

        return root;
    }
}
