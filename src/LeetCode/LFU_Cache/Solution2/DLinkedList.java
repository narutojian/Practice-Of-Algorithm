package LeetCode.LFU_Cache.Solution2;

public class DLinkedList {
    int key;
    int val;
    int freq;// 使用次数
    DLinkedList next;
    DLinkedList prev;

    public DLinkedList(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }

    public void add(DLinkedList node) {
        DLinkedList p = this.next;
        this.next = node;
        node.prev = this;
        p.prev = node;
        node.next = p;
    }

    public void delete() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}