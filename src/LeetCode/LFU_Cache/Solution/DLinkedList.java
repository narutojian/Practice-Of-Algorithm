package LeetCode.LFU_Cache.Solution;

public class DLinkedList {

    int key;
    int val;
    DLinkedList next;
    DLinkedList prev;

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
        node.prev = this;
        p.prev = node;
        node.next = p;
    }

    /**
     * 删除当前节点
     */
    public void delete() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}
