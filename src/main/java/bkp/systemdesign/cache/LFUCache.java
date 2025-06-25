package src.main.java.bkp.systemdesign.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/
 * TC: O(1), AS: O(n)
 */
class LFUCache {
    private Map<Integer, Integer> freqMap; // key, freq
    private Map<Integer, Integer> valueMap; // key, value
    private Map<Integer, LinkedHashSet<Integer>> freqKeyMap; // freq, list of keys having that freq
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.freqMap = new HashMap<>();
        this.valueMap = new HashMap<>();
        this.freqKeyMap = new HashMap<>();
        this.minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }

        Integer value = valueMap.get(key);
        int oldFreq = freqMap.get(key);
        int newFreq = oldFreq + 1;
        freqMap.put(key, newFreq);

        // Update freq value map, remove from old bucket and insert into new bucket
        freqKeyMap.get(oldFreq).remove(key);
        if (freqKeyMap.get(oldFreq).isEmpty()) {
            freqKeyMap.remove(oldFreq);
            if (minFreq == oldFreq) { // since this is min freq, so assume next higher freq is minFreq + 1
                minFreq++;
            }
        }

        freqKeyMap.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqKeyMap.get(newFreq).add(key);

        return value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (valueMap.containsKey(key)) { // existing key
            valueMap.put(key, value);
            get(key); // update freq
            return;
        } 
        
        if (valueMap.size() >= capacity) { // evict lru
            while (!freqKeyMap.containsKey(minFreq)) {
                // Because we are assuming next higher freq is minFreq + 1,
                // so correct the minFreq value here for edge cases
                // (assume cache is read intensive so more performant to put here instead of in get)
                minFreq++;
            }
            Integer keyToRemove = freqKeyMap.get(minFreq).stream().findFirst().get();
            freqKeyMap.get(minFreq).remove(keyToRemove);
            if (freqKeyMap.get(minFreq).isEmpty()) freqKeyMap.remove(minFreq);
            freqMap.remove(keyToRemove);
            valueMap.remove(keyToRemove);
        }
        
        // brand new key, so add it
        valueMap.put(key, value);
        freqMap.put(key, 1);
        freqKeyMap.putIfAbsent(1, new LinkedHashSet<>());
        freqKeyMap.get(1).add(key);
        minFreq = 1; // reset min freq
    }
}