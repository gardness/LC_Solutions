import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0451 {
    //  "tree"
    public String frequencySort(String s) {
        // cc
        if (s == null || s.length() < 2) {
            return s;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.offer(e);
        }

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> tmp = pq.poll();
            for (int i = 0; i < tmp.getValue(); i++) {
                sb.append(tmp.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
