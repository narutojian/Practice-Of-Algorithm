package LeetCode.implement_trie_prefix_tree.Solution2;


import java.util.HashMap;
import java.util.Map;

public class TreeNode {

    private char val;
    private Map<Character,TreeNode> sonMap;
    private boolean isWord;

    public TreeNode() {
    }

    public TreeNode(char val) {
        this.val = val;
        sonMap = new HashMap<>();
        isWord = false;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public TreeNode getSonNode(char val) {
        if (sonMap.containsKey(val))
            return sonMap.get(val);
        return null;
    }

    public void insertNode(TreeNode node) {
        sonMap.put(node.val,node);
    }
}
