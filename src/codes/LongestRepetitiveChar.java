public class LongestRepetitiveChar {
    
    public static void main(String[] args) {
        String s = "aaaabbbbbbaaaacccccdd";//"aabb";//
        LRC(s);
        String str = "acbdfghybdf";
        longestRepeatingSequence(str);
    }
    static String LRC(String s) {
        int current = 0, max = 0, idx = 0;
        if (s == null || s.isEmpty()) {
            
            return "";
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                current++;
            } else {
                l = r;
                current = 0;
            }
            
            if (current > max) {
                idx = l;
            }
            max = Integer.max(max, current);
        }
        System.out.println(s.charAt(idx)+" : "+max);
        return String.valueOf(s.charAt(idx));
    }
    
    static String longestRepeatingSequence(String s) {
        String lrs = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //checks for the largest common factors in every substring
                String x = lcp(s.substring(i, n), s.substring(j, n));
                // if the current prefix is greater than previous one
                // then it takes the current one as longest repeating sequence
                if (x.length() > lrs.length())
                    lrs = x;
            }
        }
        System.out.println("Longest Repeating Sequence: "+lrs);
        return lrs;
    }
    static String lcp(String s, String t) {
        //checks for longest common prefix
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }
        }
        return s.substring(0, n);
    }
}
