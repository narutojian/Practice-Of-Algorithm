package LeetCode.short_encoding_of_words;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character,TrieNode> next = new HashMap<>();

    public boolean containsKey(char ch) {
        return next.containsKey(ch);
    }

    public void put(char ch,TrieNode node) {
        next.put(ch,node);
    }

    public TrieNode get(char ch) {
        return next.get(ch);
    }

    public Character[] getKeys() {
        return next.keySet().toArray(new Character[0]);
    }
}
