package LeetCode.problem460;

import java.util.HashMap;

public class LFUCache {
    private int capacity;// 指定的缓存容量
    private HashMap<Integer,Integer> store;
    private Node head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        store = new HashMap<>(capacity);
        head = new Node();
    }

    /**
     * 获取缓存信息
     * @param key 信息对应的键
     * @return 返回对应的值
     */
    public int get(int key) {
        if (!store.containsKey(key)) return -1;
        Node first = head;
        while (first.getNext() != null && first.getNext().getKey() != key) first = first.getNext();
        // 更新频率
        Node cur =  first.getNext();
        cur.setTimes(cur.getTimes()+1);
        // 把cur从链表中断开
        first.setNext(first.getNext().getNext());
        Node second = cur;
        insertNode(cur,first);
        return store.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (store.containsKey(key)) {
            store.remove(key);
            Node temp = head;
            while (temp.getNext() != null && temp.getNext().getKey() != key) temp = temp.getNext();
            temp.setNext(temp.getNext().getNext());
        }
        if (store.size() == capacity) {
            head = head.getNext();
            store.remove(head.getKey());
        }
        Node newNode = new Node(key,0);
        insertNode(newNode,head);
        store.put(key,value);
    }

    private void insertNode(Node node, Node start) {
        while (start.getNext() != null && start.getNext().getTimes() <= node.getTimes()) start = start.getNext();
        node.setNext(start.getNext());
        start.setNext(node);
    }

    public static void main(String[] args) {
//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

//        cache.put(3,1);
//        cache.put(2,1);
//        cache.put(2,2);
//        cache.put(4,4);
//        cache.get(2);

//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回 1
//        cache.put(3, 3);    // 去除 key 2
//        cache.get(2);       // 返回 -1 (未找到key 2)
////        cache.get(3);       // 返回 3
//        cache.put(4, 4);    // 去除 key 1
//        cache.get(1);       // 返回 -1 (未找到 key 1)
//        cache.get(3);       // 返回 3
//        cache.get(4);       // 返回 4

//        LFUCache cache = new LFUCache( 1 /* capacity (缓存容量) */ );
//        cache.put(2,1);
//        cache.get(2);
//        cache.put(3,2);

        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
        cache.put(2,6);
        cache.put(1,5);
        cache.put(1,2);
    }
}
