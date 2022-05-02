package DSA.Misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ListBasedLRUCache {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println("1 => " + lru.get(1));
        lru.printQueue();
        lru.put(3, 3);
        lru.printQueue();
        System.out.println(lru.get(2));

    }
}


class LRU {
    int capacity;
    HashMap<Integer, Integer> map;
    Queue<Integer> keys;

    LRU(int capacity) {
        this.map = new HashMap<>();
        this.keys = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            updateKeys(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if (map.size() == capacity && !map.containsKey(key)) {
            evict();
        }
        map.put(key, val);
        updateKeys(key);
    }

    private void evict() {
        int removedKey = keys.remove();
        map.remove(removedKey);
    }

    private void updateKeys(int key) {
        if (keys.contains(key)) {
            keys.remove(key);
        }
        keys.add(key);
    }

    public void printQueue() {
        keys.forEach(System.out::println);
    }

}