package LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> cache;
    int curCapacity;

    public LRUCache(int capacity) {
        this.curCapacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.curCapacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    } 
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
