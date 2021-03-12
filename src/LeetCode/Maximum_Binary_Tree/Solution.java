package LeetCode.Maximum_Binary_Tree;

/**
 * 654. Maximum Binary Tree
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getRoot(nums,0,nums.length-1);
    }

    /**
     * 定义 返回构建的树的根节点
     * @param nums 值 数组
     * @param left 该树的左边界
     * @param right 有边界
     * @return
     */
    private TreeNode getRoot(int[] nums,int left,int right) {
        if (left > right)
            return null;
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = left;

        // 找出最大值的索引
        for (int i = left+1; i < right+1; i++) {
            if (nums[maxIndex] < nums[i])
                maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = getRoot(nums,left,maxIndex-1);
        root.right = getRoot(nums,maxIndex+1,right);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3,2,1,6,0,5};

        TreeNode root = solution.constructMaximumBinaryTree(nums);

    }
}
