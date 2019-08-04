package Algorithm;

import DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的遍历方法
 * 前序遍历：根节点 -> 左子树 -> 右子树
 * 中序遍历：左子树 -> 根节点 -> 右子树
 * 后序遍历：左子树 -> 右子树 -> 根节点
 * 层次遍历：按层次遍历，即广度优先遍历
 */
public class BinaryTraversal {

    /**
     * 前序遍历
     * @param root
     */
    public void preOrderTraversal(BinaryTree root){

        if (root == null) return;

        System.out.print(root.getValue()+" ");

        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderTraversal(BinaryTree root){

        if (root == null) return;
        inOrderTraversal(root.getLeft());

        System.out.print(root.getValue() +" ");

        inOrderTraversal(root.getRight());
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrderTraversal(BinaryTree root){

        if (root == null) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());

        System.out.print(root.getValue()+" ");
    }

    /**
     * 层次遍历，广度优先遍历
     * @param root
     */
    public void levelTraversal(BinaryTree root){

        Queue queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()){

            BinaryTree node = (BinaryTree) queue.poll();

            System.out.print(node.getValue()+" ");

            if (node.getLeft() != null)
                queue.offer(node.getLeft());
            if (node.getRight() != null)
                queue.offer(node.getRight());
        }
    }

    /**
     * 构建二叉树
     * @param s 字符串中的每一个字符对应一个二叉树的节点的值，第一个字符为根节点的值
     * @param adj 邻接数组
     * @return
     */
    public BinaryTree buildBinaryTree(String s, char[][] adj){

        BinaryTree[] binaryTrees = new BinaryTree[s.length()];

        for (int i = 0; i < s.length(); i++) {
            binaryTrees[i] = new BinaryTree();
            binaryTrees[i].setValue(""+s.charAt(i));
        }

        for (int i = 0; i < adj.length; i++) {

            for (int j = 0; j < adj[i].length; j++) {
                if (j == 0 && adj[i][j] != '\0')
                    binaryTrees[i].setLeft(binaryTrees[s.indexOf(adj[i][j])]);
                if (j == 1 && adj[i][j] != '\0')
                    binaryTrees[i].setRight(binaryTrees[s.indexOf(adj[i][j])]);
            }
        }

        return binaryTrees[0];
    }

    public static void main(String[] args) {

        BinaryTraversal binaryTraversal = new BinaryTraversal();

        String s = "12345678";
        char[][] chars = {
                {'2','3'},{'4','5'},{'\0','6'},{'\0','\0'},{'7','8'},
        };

        BinaryTree root = binaryTraversal.buildBinaryTree(s,chars);

        binaryTraversal.preOrderTraversal(root);
        System.out.println();

        binaryTraversal.inOrderTraversal(root);
        System.out.println();

        binaryTraversal.postOrderTraversal(root);
        System.out.println();

        binaryTraversal.levelTraversal(root);
    }
}
