import java.util.*;

public class KDiffPairs {

    public static void main(String[] args) {
        int[] nums = {6,2,9,3,9,6,7,7,6,4};//{3,1,4,1,5};

        //
        int k = 3;
        findPairs(nums,k);
        findPairs2(nums,k);
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums) {
            if (map.containsKey(i)) {
                //System.out.println(k+" <> "+map.get(i)+" <i> "+i);
                if (k == 0 && map.get(i) == 1) {
                    System.out.println("<>"+map.get(i));
                    map.put(i, map.get(i) + 1);
                    res++;
                }
                continue;
            }
            res += map.getOrDefault(i + k, 0);
            res += map.getOrDefault(i - k, 0);

            map.put(i, 1);
        }
        //System.out.println(res);
        return res;
    }

    static int findPairs2(int[] nums, int k){
        int result = 0;
        if(k < 0)
            return 0;

        if(k == 0){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums){
                int val = map.getOrDefault(i,0);
                map.put(i,val+1);
            }
            //map.forEach((x,y) -> System.out.println(x+" : "+y));
            Collection<Integer> list = map.values();
            for(Integer i : list)
                if(i > 1)result++;

        }else{
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums)
                set.add(i);

            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                int val = iterator.next();

                int pair = val - k;

                if(set.contains(pair))
                    result++;
            }
        }
        System.out.println(result);
        return result;
    }
}
