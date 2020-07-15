package codes;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequent(words,k).forEach(System.out::println);

    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> freqMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word: words)
            freqMap.put(word,freqMap.getOrDefault(word,0)+1);

        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()): b.getValue() - a.getValue());

        for(Map.Entry<String,Integer> entry: freqMap.entrySet())
            priorityQueue.offer(entry);

        while(priorityQueue.size() > 0){
            Map.Entry<String,Integer> temp = priorityQueue.poll();
            if(k-- > 0){
                result.add(temp.getKey());
            }
            if(k==0)break;;
        }

        return result;
    }
}
