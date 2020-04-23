import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] input = {"nftk","fqizrrnmif","qrkgmliewc","qkjzgws","htpvnmozay","qengse","nsfspyox","hdemkfr","qggx","glarko","pwqvwmlgri","ijy","zskaqzwo","zlfiwwb"};


        System.out.println(new TopKFrequentWords().topKFrequent(input, 14));
    }

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < k) {
            return null;
        }

        List<String> resultList;
        // to store values sorted by key for lexicografical sorting
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // smallest element on top
        Queue<String> priorityQueue = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b));

        for (String word : map.keySet()) {
            priorityQueue.add(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        resultList = new ArrayList<>(priorityQueue);


        return resultList;

    }
}