package Test;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        System.out.println(map.toString());


        // Default Sorting in TreeMap
        TreeMap<String, String> stringMap = new TreeMap<>();

        stringMap.put("c", "val");
        stringMap.put("b", "val");
        stringMap.put("a", "val");
        stringMap.put("e", "val");
        stringMap.put("d", "val");

        System.out.println(stringMap.toString());


        // Custom Sorting in TreeMap
        TreeMap<Integer, String> customMap = new TreeMap<>((a, b) -> b - a);

        customMap.put(3, "val");
        customMap.put(2, "val");
        customMap.put(1, "val");
        customMap.put(5, "val");
        customMap.put(4, "val");

        System.out.println(customMap.toString());


        // Importance of TreeMap Sorting
        TreeMap<Integer, String> impMap = new TreeMap<>();

        impMap.put(3, "val");
        impMap.put(2, "val");
        impMap.put(1, "val");
        impMap.put(5, "val");
        impMap.put(4, "val");

        Integer highestKey = map.lastKey();
        Integer lowestKey = map.firstKey();
        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
        Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

        System.out.println(keysLessThan3.toString());
        System.out.println(keysGreaterThanEqTo3.toString());
    }
}
