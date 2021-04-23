package LeetCode.LRU_Cache.Solution;

import java.util.*;

/**
 * 146. LRU Cache
 *
 * hash+单链表实现
 *
 */
public class LRUCache {
    private int n;
    private List<Integer> list;
    private Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        n = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        adjust(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        adjust(key);
        if (!map.containsKey(key)) {
            if (list.size() == n) {
                Integer data = list.remove(0);
                map.remove(data);
            }
            list.add(key);
        }
        map.put(key,value);// 可能会出现同一个key value改变
    }

    private void adjust(Integer key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,1);
        lruCache.put(2,2);

        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
    }
}
