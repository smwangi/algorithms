
import java.util.*;
//import org.hamcrest.Matchers;


public class TreeMapHashMap {
  
    public static void main(String[] args) {
        
    }

    private static void whenInsertObjectsTreeMap_thenNaturalOrder(){

        Map<Integer,String>treeMap = new TreeMap<>();
        treeMap.put(3, "three");
        treeMap.put(2,"two");
        treeMap.put(1,"one");

        //assertThat(treeMap.keySet(),contains(1,2,3));
    }
}