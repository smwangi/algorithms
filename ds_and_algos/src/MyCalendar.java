import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Integer lessThanStart = map.floorKey(start);

        if (lessThanStart != null) {
            int v = map.get(lessThanStart).intValue();
            System.out.println(v);
        }

        if (lessThanStart != null && map.get(lessThanStart) > start) {
            return false;
        }

        Integer greatestThanStart = map.ceilingKey(start);
        if (greatestThanStart != null  && greatestThanStart < end) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}
