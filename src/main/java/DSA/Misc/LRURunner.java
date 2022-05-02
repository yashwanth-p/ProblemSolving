package DSA.Misc;

import java.util.LinkedList;
import java.util.*;

public class LRURunner {
    public static void main(String[] args) {
        firstUniqueExec();
        lruExec();
        pageFaultsExec(new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}, 4);
    }

    private static void pageFaultsExec(int[] pages, int size) {
        int faults = 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int page : pages) {
            if (set.size() == size) {
                if (!set.contains(page)) {
                    int x = q.peek();
                    q.remove();
                    set.remove(x);
                }
            }
            if (!set.contains(page)) {
                faults++;
                q.add(page);
                set.add(page);
            }


        }
        System.out.println("Page Faults for LIFO: "+faults);

    }

    private static void lruExec() {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 23);
        cache.put(10, 15);
        cache.put(4, 10);
        cache.get(1);
        cache.put(3, 44);
        cache.put(5, 22);
        cache.put(11, 22);
    }

    private static void firstUniqueExec() {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 4});
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
    }
}

class FirstUnique {

    Map<Integer, Integer> map = new LinkedHashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 0 : count;
            map.put(num, ++count);
        }
    }

    public int showFirstUnique() {

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = (int) entry.getKey();
            int val = (int) entry.getValue();
            // first element with unique value
            if (val == 1) {
                return key;
            }
        }
        return -1;

    }

    public void add(int value) {
        Integer count = map.get(value);
        count = count == null ? 0 : count;
        map.put(value, ++count);
    }
}


class LRUCache {

    Map<Integer, Item> hm = new HashMap<>();
    int capacity = 0;
    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Item item = hm.get(key);
        if (item == null) return -1;
        item.accessTime = System.nanoTime();
        return item.value;
    }

    public void put(int key, int value) {
        // evict
        if (count == capacity) {
            int keyToRemove = -1;
            long lastAccessTime = Long.MAX_VALUE;

            for (Map.Entry<Integer, Item> entry : hm.entrySet()) {
                int key1 = (int) ((Map.Entry) entry).getKey();
                Item val = (Item) ((Map.Entry) entry).getValue();

                if (val.accessTime < lastAccessTime) {
                    lastAccessTime = val.accessTime;
                    keyToRemove = key1;
                }
            }

            hm.remove(keyToRemove);
            System.out.println("Removed LRU item : " + keyToRemove);
            count--;
        }
        // base case
        hm.put(key, new Item(value));
        count++;
    }
}

class Item {
    int value;
    long accessTime;

    Item(int value) {
        this.value = value;
        this.accessTime = System.nanoTime();
    }

}
