import java.util.*;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 *
 * Example 2:
 *
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 *
 * Example 3:
 *
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 105
 *     s contains only lowercase English letters.
 */
public class MinimumDeletionsToMakeCharFreqUnique {

    public static void main(String[] args) {
        String s="aaabbbcc";
        System.out.println(minCntCharDeletionsfrequency(s.toCharArray()));
        System.out.println(minDeletes(s));
        System.out.println(minimumDeletions(s));
    }
    /**
     * Solution
     * Approach: The problem can be solved using Greedy technique.
     * The idea is to use Map and Priority Queue. Follow the steps below to solve the problem:
     *
     *     Initialize a Map, say mp, to store the frequency of each distinct character of the string.
     *     Initialize a variable, say cntChar to store the count of characters required to be removed to make frequency of each character of the string unique.
     *     Create a priority_queue, say pq to store the frequency of each character such that the largest frequency obtained is present at the top of the priority queue pq.
     *     Iterate over the priority_queue until pq is empty and check if the topmost of element of pq is equal to the second topmost element of pq or not. If found to be true, then decrement the value of topmost element of pq by 1 and increment the value of cntChar by 1.
     *     Otherwise, pop the topmost element of pq.
     *     Finally, print the value of cntChar.
     */
    static int minCntCharDeletionsfrequency(char[] str){
        //Store the frequency of each char in a map
        Map<Character,Integer> map = new HashMap<>();

        //Store the frequency of each distinct char such that the largest frequency is present at the top
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        //Store minimum count of characters required to delete to make
        //frequency is present at the top
        int countChar = 0;

        for(int i = 0; i< str.length;i++){
            map.put(str[i],map.getOrDefault(str[i],0)+1);
        }
        for(Map.Entry<Character,Integer> it: map.entrySet()){
            //insert current frequency into priority queue
            priorityQueue.add(it.getValue());
        }
        //Traverse the priority queue
        while (!priorityQueue.isEmpty()){
            //Store the top most element if PQ
            int frequent = priorityQueue.peek();
            //Remove the top most
            priorityQueue.poll();
            if(priorityQueue.isEmpty())return countChar;
            //if frequent and topmost element of PQ are equal
            if(frequent == priorityQueue.peek()){
                //if frequency of the topmost element is greater than 1
                if(frequent > 1){
                    //Insert the decremented value of frequent
                    priorityQueue.add(frequent-1);
                }
                //update countChar
                countChar++;
            }
        }
        return countChar;
    }

    /**
     * Second Approach
     *     Construct array count[] which contains a count for each character. Below are the steps to how to construct that array.
     *         Create an array charCount[] of size 26 and fill with 0.
     *         Iterate the array and maintain the count of each letter in the array charCount[] so that count of character a, b, c, ,,,,, z will be stored at index 0, 1, 2, ,,,,, 25 respectively.
     *         Once the iteration is completed copy all the elements with non zero count to array list and convert that list to count[].
     *     Once count[] is constructed, Sort the count[] in descending order.
     *     Initialize deletes = 0.
     *     Iterate the count[] from left to right, for current element i
     *         Iterate elements from j = i+1 to end and if count[i]==count[j], reduce the count at index j and do deletes++  else break the loop. (array is sorted, so you will not find another index j which is equal to index i).
     *     Return deletes
     *     See the walkthrough below for more understanding.
     */
    static int minDeletes(String s){
        //Count all chars and store them in an array of 26 chars
        Integer[] charCounts = new Integer[26];
        Arrays.fill(charCounts,0);

        for (int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            int count = charCounts[index];
            charCounts[index] = count+1;
        }
        //create list of counts
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<charCounts.length;i++){
            if(charCounts[i] >0)
                list.add(charCounts[i]);
        }

        //sort the array list in descending order
        Collections.sort(list,Collections.reverseOrder());
        Integer[]counts  = list.toArray(new Integer[list.size()]);

        int deletions = 0;
        //Iterate from left to right and if the count is the same reduce the right
        for(int i =0;i<counts.length-1;i++){
            for(int j = i+1; j<counts.length;j++){
                if(counts[i]>0 && counts[i]==counts[j]){
                    int count = counts[j];
                    counts[j] = count-1;
                    deletions++;
                }else break;
            }
        }
        return deletions;
    }

    static int minimumDeletions(String s){
        //Create a bucket to store the frequencies of all characters
        int[]bucket = new int[26];
        for (char c:s.toCharArray()){
            bucket[c-'a']++;
        }
        int count = 0;
        HashSet<Integer> set = new HashSet<>();//Store if a certain frequency is present
        for(int i=0;i<bucket.length;i++){
            if(bucket[i] != 0){
                if(!set.contains(bucket[i])){
                    set.add(bucket[i]);
                }else {
                    int k = bucket[i];
                    while (true){
                        k -=1;
                        count++;
                        if(!set.contains(k)){
                            if(k!=0){
                                set.add(k);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
