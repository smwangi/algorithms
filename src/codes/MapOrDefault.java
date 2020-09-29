import java.util.*;
/**
 * MapOrDefault
 */
public class MapOrDefault {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); 
        map.put("a", 100); 
        map.put("b", 200); 
        map.put("c", 300); 
        map.put("d", 400);

        // provide key whose value has to be obtained 
        // and default value for the key. Store the 
        // return value in k 
        int k = map.getOrDefault("e", 500); 
  
        // print the value of k returned by 
        // getOrDefault(Object key, V defaultValue) method 
        System.out.println("Returned Value: " + k); 
    }
}
