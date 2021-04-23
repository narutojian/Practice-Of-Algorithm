package LeetCode.LRU_Cache.Solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * hash+双向循环链表
 */
public class LRUCache {
    private int capacity;
    private DLinkedList head;// 哨兵节点
    private Map<Integer,DLinkedList> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList(-1,-1);
        head.next = head;
        head.pre = head;

        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        // 更新下位置
        DLinkedList cur = map.get(key);
        cur.delete();
        head.add(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedList cur = map.get(key);
            cur.val = value;
            cur.delete();
            head.add(cur);
        }
        else {
            if (map.size() == capacity) {
                DLinkedList last = head.pre;
                map.remove(last.key);
                head.pre.delete();
            }
            DLinkedList node = new DLinkedList(key,value);
            head.add(node);
            map.put(key,node);
        }
    }
}
