import java.util.*;

public class LC0692 {
    // ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
    public List<String> topKFrequent(String[] words, int k) {
        // cc
        if (words == null || words.length == 0) {
            return null;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        if (e1.getValue() != e2.getValue()) {
                            return e2.getValue() - e1.getValue();
                        } else {
                            return e1.getKey().compareTo(e2.getKey());
                        }
                    }
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        List<String> res = new LinkedList<>();

        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }

        return res;
    }
}
