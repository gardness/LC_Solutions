package Test;

import java.util.*;

public class LinkedHashMapTest {
    public static class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final int MAX_ENTRIES = 5;

        public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        Integer[] arr = keys.toArray(new Integer[0]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>(16, .75f, true);
        map1.put(1, null);
        map1.put(2, null);
        map1.put(3, null);
        map1.put(4, null);
        map1.put(5, null);

        Set<Integer> mykeys = map1.keySet();
        System.out.println(mykeys.toString());

        map1.get(4);
        System.out.println(mykeys.toString());

        map1.get(1);
        System.out.println(mykeys.toString());

        map1.get(3);
        System.out.println(mykeys.toString());


        LinkedHashMap<Integer, String> myMap = new MyLinkedHashMap<>(16, .75f, true);
        myMap.put(1, null);
        myMap.put(2, null);
        myMap.put(3, null);
        myMap.put(4, null);
        myMap.put(5, null);

        Set<Integer> newKeys = map.keySet();
        System.out.println(newKeys.toString());

        map.put(6, null);
        System.out.println(newKeys.toString());

        map.put(7, null);
        System.out.println(newKeys.toString());

        map.put(8, null);
        System.out.println(newKeys.toString());


        Map m = Collections.synchronizedMap(new LinkedHashMap<>());




    }
}
