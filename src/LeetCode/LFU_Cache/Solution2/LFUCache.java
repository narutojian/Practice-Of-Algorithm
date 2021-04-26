package LeetCode.LFU_Cache.Solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache
 *
 * 双Map
 */
public class LFUCache {
    private int capacity;
    private Map<Integer,DLinkedList> keyMap;
    private Map<Integer,DLinkedList> freqMap;
    private int minFreq = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        DLinkedList cur = keyMap.get(key);
        if (cur == null)
            return -1;
        // 在freqMap中删除cur
        cur.delete();
        // 更新minFreq
        updateMinFreq(cur.freq);
        // 更新freq 之后再加回freqMap中
        cur.freq++;
        addNodeToFreq(cur.freq,cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        DLinkedList cur = keyMap.get(key);
        if (cur == null) {
            // 满了 要删除
            if (capacity == keyMap.size()) {
                DLinkedList rm = freqMap.get(minFreq).prev;
                keyMap.remove(rm.key);
                rm.delete();
            }
            DLinkedList node = new DLinkedList(key,value,1);
            addNodeToFreq(1,node);
            minFreq = 1;
            keyMap.put(key,node);
        }
        else {
            cur.delete();
            // 更新minFreq
            updateMinFreq(cur.freq);
            cur.freq++;
            cur.val = value;
            addNodeToFreq(cur.freq,cur);
        }
    }

    private void addNodeToFreq(int freq,DLinkedList node) {
        if (freqMap.get(freq) == null) {
            DLinkedList head = new DLinkedList(-1,-1,-1);
            head.prev = head;
            head.next = head;
            freqMap.put(freq,head);
        }
        freqMap.get(freq).add(node);
    }

    private void updateMinFreq(int rmFreq) {
        if (minFreq == rmFreq) {
            DLinkedList head = freqMap.get(rmFreq);
            if (head.next == head)
                minFreq++;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
    }
}
