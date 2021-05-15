package Fudan.第一题;

/**
 * 第一题
 */
public class Solution {

    /**
     * 计算关键节点的接口
     * 给定一棵树 返回关键节点数
     * @param root 根节点
     * @return 关键节点数
     */
    public int getKeyNode(TreeNode root) {
        return getNum(root,-1);
    }

    /**
     * 定义：返回以root为根节点的树的关键节点数
     * @param root 根节点
     * @param maxVal 当前路径上的最大值
     * @return 关键节点数
     */
    public int getNum(TreeNode root,int maxVal) {
        if (root == null)
            return 0;
        int res = 0;
        if (maxVal <= root.val) {
            res++;
            maxVal = root.val;
        }
        res += getNum(root.left,maxVal);
        res += getNum(root.right,maxVal);

        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(5);

//        TreeNode root = null;

//        TreeNode root = new TreeNode(3);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(solution.getKeyNode(root));
    }
}
