package LeetCode.implement_trie_prefix_tree;

/**
 * 208. Implement Trie (Prefix Tree)
 */
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pos = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!pos.containsKey(ch)) {
                pos.put(ch,new TrieNode());
            }
            pos = pos.get(ch);
        }
        pos.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pos = root;
        for (char ch : word.toCharArray()) {
            if (!pos.containsKey(ch)) {
                return false;
            }
            pos = pos.get(ch);
        }
        if (pos.isEnd()) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pos = root;
        for (char ch : prefix.toCharArray()) {
            if (!pos.containsKey(ch)) {
                return false;
            }
            pos = pos.get(ch);
        }
        return true;
    }
}
