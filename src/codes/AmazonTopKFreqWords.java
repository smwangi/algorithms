package codes;

import java.sql.Array;
import java.util.*;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 *
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 *
 * Example 1:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 *   "Anacell provides the best services in the city",
 *   "betacellular has awesome services",
 *   "Best services provided by anacell, everyone should use anacell",
 * ]
 *
 * Output:
 * ["anacell", "betacellular"]
 *
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 *
 * Example 2:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 * reviews = [
 *   "I love anacell Best services; Best services provided by anacell",
 *   "betacellular has great services",
 *   "deltacellular provides much better services than betacellular",
 *   "cetracular is worse than anacell",
 *   "Betacellular is better than deltacellular.",
 * ]
 *
 * Output:
 * ["betacellular", "anacell"]
 *
 * Explanation:
 * "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 *
 * Related problems:
 *
 *     https://leetcode.com/problems/top-k-frequent-words/
 *     https://leetcode.com/problems/top-k-frequent-elements/
 */
public class AmazonTopKFreqWords {

    public static void main(String[] args) {
        String[] keywords = {"anacell", "cetracular", "betacellular"};
        String[] reviews = {
                "Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",
        };

        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };

        int k = 2;
         topKWords(reviews2, keywords2, k).forEach(x -> System.out.println(x));
    }

    static List<String> topKWords(String[]reviews,String[] keywords,int k){

        //Store words and their count
        Map<String,Integer>map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(keywords));
        List<String> ans = new ArrayList<>();

        for (String s: reviews){

            String[]strings = s.split("\\W");
            Set<String> added = new HashSet<>();

            for (String str: strings){
                str = str.toLowerCase();
                if(set.contains(str) && !added.contains(str)){
                    map.put(str, map.getOrDefault(str,0)+1);
                    added.add(str);
                }
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>((a,b)-> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue() );
        priorityQueue.addAll(map.entrySet());


        while (!priorityQueue.isEmpty() && k-- > 0){
           ans.add(priorityQueue.poll().getKey());
        }
        return ans;
    }
}
