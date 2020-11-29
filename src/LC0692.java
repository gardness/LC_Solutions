import java.util.*;

public class LC0692 {
    class Word {
        String word;
        int freq;

        Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    // With Class
    // ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    public List<String> topKFrequent(String[] words, int k) {
        // cc
        if (words == null || words.length == 0) {
            return new LinkedList<>();
        }

        HashMap<String, Word> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new Word(word, 1));
            } else {
                map.get(word).freq++;
            }
        }

        // MinHeap
        PriorityQueue<Word> pq = new PriorityQueue<>(k + 1, new Comparator<Word>() {
            @Override
            public int compare(Word fWord, Word sWord) {
                if (fWord.freq == sWord.freq) {
                    return sWord.word.compareTo(fWord.word);
                } else {
                    return fWord.freq - sWord.freq;
                }
            }
        });

        int cnt = 0;
        for (Word tmp : map.values()) {
            if (cnt < k) {
                pq.offer(tmp);
                cnt++;
            } else {
                if (tmp.freq >= pq.peek().freq) {
                    pq.offer(tmp);
                    pq.poll();
                }
            }
        }

        List<String> res = new LinkedList<>();

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().word);
        }

        return res;
    }


    // Without Class
    public List<String> topKFrequent1(String[] words, int k) {
        // cc
        if (words == null || words.length == 0) {
            return new LinkedList<>();
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue(k + 1,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        return e1.getValue() == e2.getValue() ?
                                e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue();
                    }
                });

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (cnt < k - 1) {
                minHeap.offer(entry);
                cnt++;
            } else {
                if (entry.getValue() >= minHeap.peek().getValue()) {
                    minHeap.offer(entry);
                    minHeap.poll();
                }
            }
        }

        List<String> res = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().getKey());
        }

        return res;
    }


    // Using Collections
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1) == count.get(w2) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }


    // TreeSet
    // Time Complexity : O()
    // Space Complexity : O()
    public List<String> topKFrequent3(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        TreeSet<String>[] buckets = new TreeSet[words.length + 1];

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String word = e.getKey();
            int freq = e.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new TreeSet<>();
            }

            buckets[freq].add(word);
        }

        List<String> res = new LinkedList<>();

        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                TreeSet<String> tmp = buckets[i];

                if (tmp.size() < k) {
                    k -= tmp.size();

                    while (tmp.size() > 0) {
                        res.add(tmp.pollFirst());
                    }
                } else {
                    while (k-- > 0) {
                        res.add(tmp.pollFirst());
                    }

                    break;
                }
            }
        }

        return res;
    }


//    public List<String> topKFrequent4(String[] words, int k) {
//
//    }

    public static void main(String[] args) {
        LC0692 solution = new LC0692();
        solution.topKFrequent3(new String[]{"the", "day", "is", "sunny", "the"
                , "the", "the", "sunny", "is", "is"}, 4);
    }
}