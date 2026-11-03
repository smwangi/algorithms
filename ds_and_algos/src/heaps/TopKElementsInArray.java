package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TopKElementsInArray {

    public static void main(String[] args) {
        var list = Arrays.asList(1,4,5,9,10,8);
        int k = 3;
        findTopK(list,k).forEach(x -> System.out.print(x+" "));
        System.out.println();
        findTopKQ(list,k).forEach(x -> System.out.print(x+" "));
    }

    //O(logn)
    public static List<Integer> findTopK(List<Integer> input,int k){
        Set<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(input);

        return sortedSet.stream().limit(k).collect(Collectors.toList());
    }

    //Priority Queue
    private static List<Integer> findTopKQ(List<Integer> input, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        input.forEach(num -> {
            maxHeap.add(num);

            if(maxHeap.size() > k)
                maxHeap.poll();
        });
        List<Integer> topKList = new ArrayList<>(maxHeap);
        Collections.reverse(topKList);

        return topKList;
    }
}
