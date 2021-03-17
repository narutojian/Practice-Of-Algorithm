package LeetCode.Serialize_and_Deserialize_Binary_Tree;

import LeetCode.DS.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class Codec {

    final char NULL = '#';
    final char seq = ',';
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    /**
     * 前序 序列化
     * @param root
     * @param sb
     */
    private void serialize(TreeNode root,StringBuilder sb) {
        if (root == null) {
            sb.append(NULL);
            return;
        }
        sb.append(root.val).append(seq);
        serialize(root.left,sb);
        sb.append(seq);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] newData = data.split(",");
        index = 0;
        return deserialize(newData);
    }

    private TreeNode deserialize(String[] data) {
        if (data[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        String s = codec.serialize(root);

        System.out.println(s);

        TreeNode newRoot = codec.deserialize(s);

        System.out.println(newRoot);
    }
}
