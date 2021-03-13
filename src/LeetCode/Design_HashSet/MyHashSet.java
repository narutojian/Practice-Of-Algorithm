package LeetCode.Design_HashSet;

import java.util.LinkedList;

/**
 * 705. Design HashSet
 * 哈希函数 除模取余法
 * 冲突解决方法 链地址法
 * 扩容 链表
 */
public class MyHashSet {
    int mod = 769;
    LinkedList<Integer> [] store;

    /** Initialize your data structure here. */
    public MyHashSet() {
        store = new LinkedList[mod];
        for (int i = 0; i < mod; i++) {
            store[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hashVal = hash(key);
        for (int val : store[hashVal]) {
            if (val == key)
                return;
        }
        store[hashVal].add(key);
    }

    public void remove(int key) {
        int hashVal = hash(key);
        boolean flag = false;
        for (int val : store[hashVal]) {
            if (val == key) {
                flag = true;
                break;
            }
        }
        if (flag)
            store[hashVal].remove((Integer)key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashVal = hash(key);
        for (int val : store[hashVal]) {
            if (val == key)
                return true;
        }
        return false;
    }

    private int hash(int key) {
        return key % mod;
    }
}
