package LeetCode.Populating_Next_Right_Pointers_in_Each_Node;

public class Solution2 {

    public Node connect(Node root) {
        if (root == null)
            return null;
        connectTowNode(root.left,root.right);
        return root;
    }

    /**
     * 递归 优化
     * @param node1
     * @param node2
     */
    private void connectTowNode(Node node1,Node node2) {
        if (node1 == null)
            return;
        node1.next = node2;

        // 连接同一个父节点下的左右节点
        connectTowNode(node1.left,node1.right);
        connectTowNode(node2.left,node2.right);
        // 连接不同父节点下的左右节点
        connectTowNode(node1.right,node2.left);
    }
}
