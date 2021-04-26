package LeetCode.LFU_Cache.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache
 */
public class LFUCache {

    private int capacity;
    private DLinkedList head;// 按时间顺序链接节点，新的在后，旧的在前
    private Map<Integer,Integer> cnt;// 计数器
    private Map<Integer,DLinkedList> map;// 定位器
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList(-1,-1);
        head.prev = head;
        head.next = head;
        cnt = new HashMap<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        DLinkedList node = map.get(key);
        if (node == null)
            return -1;
        // 更新链表的顺序 把新用到的提前
        node.delete();
        head.prev.add(node);
        // 更新计数器
        cnt.put(key,cnt.get(key)+1);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        DLinkedList node = map.get(key);
        if (node == null) { // 新增节点
            if (map.size() == capacity) { // 空间占满 删除一个
                DLinkedList cur = head.next;
                DLinkedList rm = cur;
                while (cur != head) {
                    if (cnt.get(cur.key) < cnt.get(rm.key)) {
                        rm = cur;
                    }
                    cur = cur.next;
                }
                map.remove(rm.key);
                cnt.remove(rm.key);
                rm.delete();// 删除节点
            }
            DLinkedList addNode = new DLinkedList(key,value);
            head.prev.add(addNode);
            map.put(key,addNode);
            cnt.put(key,1);
        }
        else {
            // 更新计数器
            cnt.put(key,cnt.get(key)+1);
            // 更新值
            map.get(key).val = value;
            // 更新链表顺序
            node.delete();
            head.prev.add(node);
        }
    }
}
