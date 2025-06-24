package src.main.java.bkp.systemdesign.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
  public static final int LRU_CACHE_SIZE = 2;

  public static void main(String[] args) {
    LinkedHashMap<Integer, Integer> lruCache =
        new LinkedHashMap<Integer, Integer>(10, 0.75f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > LRU_CACHE_SIZE;
          }
        };
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    lruCache.put(3, 3);
    lruCache.get(1);
    lruCache.get(2);
    lruCache.get(3);
    lruCache.get(3);
    lruCache.get(2);
    System.out.println(lruCache);
  }
}
