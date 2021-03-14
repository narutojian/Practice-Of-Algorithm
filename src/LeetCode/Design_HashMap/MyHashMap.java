package LeetCode.Design_HashMap;

import java.util.LinkedList;

/**
 * 706. Design HashMap
 * 链地址法设计hashmap
 */
public class MyHashMap {
    final int mod = 769;
    LinkedList<int[]>[] store;

    /** Initialize your data structure here. */
    public MyHashMap() {
        store = new LinkedList[mod];
        for (int i = 0; i < mod; i++) {
            store[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashVal = hash(key);
        for (int[] temp : store[hashVal]) {
            if (temp[0] == key) {
                temp[1] = value;
                return;
            }
        }
        store[hashVal].add(new int[]{key,value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashVal = hash(key);
        for (int[] temp : store[hashVal]) {
            if (temp[0] == key)
                return temp[1];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashVal = hash(key);

        for (int[] temp : store[hashVal]) {
            if (temp[0] == key) {
                store[hashVal].remove(temp);
                return;
            }
        }
    }

    private int hash(int key) {
        return key%mod;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1,1);
        myHashMap.remove(1);
    }
}
