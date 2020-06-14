package LeetCode.implement_trie_prefix_tree;

/**
 * trie树的节点结构
 * trie树的根节点的值为空，以路径保存字符串，每一条边都是一个字符
 */
public class TrieNode {
    // 子节点，数组中的索引代表着指向该索引下的节点的边的值
    // 称为字母映射表也不错
    private TrieNode[] links;
    // 最多有26种子节点的关系
    private final int R = 26;
    // 当前节点是否为一个字符串的最后一个节点,默认为false
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    /**
     * 当前节点是否已经存在有边的值为ch的子节点
     * @param ch
     * @return
     */
    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch,TrieNode node) {
        links[ch-'a'] = node;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
