
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FiboDynamicProg
 */
public class FiboDynamicProg {

    private static Map<Integer,Long> memo = new  ConcurrentHashMap<>();// CHashMap<>();
    static{
        memo.put(0, 0l);
        memo.put(1, 1l);
    }
    public static void main(String[] args) {
        //fibonacci(5);
        fibonacci(5);
        //memo.forEach(x->System.out::print);
        memo.entrySet().forEach(n->{
            System.out.println(n.getKey()+" "+n.getValue());
        });
        System.out.println();
    }
    static long fibonacci(int x){
        //return x;
       //return memo.computeIfAbsent(x, n->fibonacci(n-1) + fibonacci(n-2));
       return memo.computeIfAbsent(x, n -> Math.addExact(fibonacci(n-1) , fibonacci(n-2)));
    }
}