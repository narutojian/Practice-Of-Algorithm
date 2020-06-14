package LeetCode.short_encoding_of_words;

/**
 * 820. Short Encoding of Words
 */
public class Solution {
    private Trie trie = new Trie();
    private int ans = 0;

    /**
     * 字典树（前缀树）
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {

        for (String word : words) {
            trie.insert(word);
        }
        dfs(trie.getRoot(),0);
        return ans;
    }

    public void dfs(TrieNode root,int edgeNum) {
        Character[] keys = root.getKeys();
        if (keys.length == 0) {
            ans += edgeNum+1;
            return;
        }

        for (char ch : keys) {
            dfs(root.get(ch),edgeNum+1);
        }
    }

    public static void main(String[] args) {
        Solution h = new Solution();

//        String[] words = {"time","me","bell"};
        String[] words = {"time","me","beme","alme","bell"};

        System.out.println(h.minimumLengthEncoding(words));
    }
}
