package LeetCode.short_encoding_of_words;

public class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode pos = root;
        char[] chars = word.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            if (!pos.containsKey(chars[i])) {
                pos.put(chars[i],new TrieNode());
            }
            pos = pos.get(chars[i]);
        }
    }

    public TrieNode getRoot() {
        return root;
    }
}
