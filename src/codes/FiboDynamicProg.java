
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FiboDynamicProg
 */
public class FiboDynamicProg {
    static Map<Integer, Integer> memoize = new HashMap<>();
    private static Map<Integer,Long> memo = new  ConcurrentHashMap<>();// CHashMap<>();
    static{
        memo.put(0, 0l);
        memo.put(1, 1l);
    }
    public static void main(String[] args) {
        //fibonacci(5);
        /*fibonacci(5);
        //memo.forEach(x->System.out::print);
        memo.entrySet().forEach(n->{
            System.out.println(n.getKey()+" "+n.getValue());
        });
        System.out.println();*/
        int n = 15;
        System.out.println(fib(n));
    }
    static long fibonacci(int x){
        //return x;
       //return memo.computeIfAbsent(x, n->fibonacci(n-1) + fibonacci(n-2));
       return memo.computeIfAbsent(x, n -> Math.addExact(fibonacci(n-1) , fibonacci(n-2)));
    }
    
    public static int fib(int n) {
        if(n ==  0 || n == 1) return n;
        
        //see if we have calculated this
        if(memoize.containsKey(n)) {
            System.out.printf("grabbing memo[%d]\n",n);
            return memoize.get(n);
        }
        System.out.printf("computing fib(%d)\n",n);
        int result = fib(n - 1) + fib(n - 2);
        //memoize
        memoize.put(n, result);
        
        return result;
    }
}