package LeetCode.implement_trie_prefix_tree.Solution2;

public class Trie {
    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 先找出word在root中的最后一个字符，然后把不在那部分字符加入到root中
        TreeNode pre = root;
        int i = 0;
        for (; i < word.length(); i++) {
            char val = word.charAt(i);
            TreeNode cur = pre.getSonNode(val);
            if (cur == null)
                break;
            pre = cur;
        }
        while (i < word.length()) {
            TreeNode node = new TreeNode(word.charAt(i));
            pre.insertNode(node);
            pre = node;
            i++;
        }
        pre.setWord(true);// 从root到该节点形成一个字符串
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode lastNode = findNode(word);
        return lastNode == null ? false : lastNode.isWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode lastNode = findNode(prefix);
        return lastNode == null ? false : true;
    }

    private TreeNode findNode(String word) {
        TreeNode pre = root;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            TreeNode cur = pre.getSonNode(val);
            if (cur == null)
                return null;
            pre = cur;
        }
        return pre;
    }
}
