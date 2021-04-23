package LeetCode.LRU_Cache.Solution2;

/**
 * 双向链表
 */
public class DLinkedList {
    int key;
    int val;
    DLinkedList next;
    DLinkedList pre;

    public DLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }

    /**
     * 插入一个节点为当前节点的下一个节点
     * @param node
     */
    public void add(DLinkedList node) {
        DLinkedList p = this.next;
        this.next = node;
        node.pre = this;
        p.pre = node;
        node.next = p;
    }

    /**
     * 删除当前节点
     */
    public void delete() {
        this.pre.next = this.next;
        this.next.pre = this.pre;
    }
}
