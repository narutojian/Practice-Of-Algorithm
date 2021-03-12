package LeetCode.Populating_Next_Right_Pointers_in_Each_Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class Solution {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null)
            return null;
        inOrder(Arrays.asList(root));
        return root;
    }

    /**
     * 递归 层次遍历
     * @param store
     */
    private void inOrder(List<Node> store) {
        if (store.size() == 0)
            return;
        List<Node> nextLevel = new ArrayList<>();
        for (int i = 0; i < store.size(); i++) {
            if (i != store.size()-1) {
                store.get(i).next = store.get(i+1);
            }
            if (store.get(i).left != null) {
                nextLevel.add(store.get(i).left);
                nextLevel.add(store.get(i).right);
            }
        }
        inOrder(nextLevel);
    }
}
