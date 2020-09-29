

import java.util.stream.Stream;




public class TestJava {

    public static void main(String[] args) {
        int x = 1;
        System.out.println("Test");
        while (x <= 4) {
            System.out.println("Value of x: " + x);
            x++;
        }

        /*Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());*/

        //Streams, flatmap map
        var names = Stream.of("sam","wan","mwan");
        names.map(n -> n.toUpperCase()).forEach(System.out::println);

        //Optional<String> opt = Optional.of("test");
       // assertEquals(Optional.of("TEST"),opt.map(String::toUpperCase));
        long[] arr = {1,3,5,7,9};
        minMax(arr);
    }

    private static void minMax(long[] arr){
        long minVal = 0;// Long.MAX_VALUE;
        long maxVal = 0;
       
        for(int i = 0; i< 5;i++){
            long minF = sumOfNumbers(i, arr);
            long maxF = sumOfNumbers(i, arr);
            if(i == 0){
                minVal = minF;
                maxVal = maxF;
            }
            if(minF < minVal){
                minVal = minF;
            }
            if(maxF > maxVal){
                maxVal = maxF;
            }
        }
        System.out.println(minVal + " " + maxVal);

    }

    static long sumOfNumbers(int a, long[] arr){
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(a != i){
                sum +=arr[i];
            }
        }
        return sum;
    }
}