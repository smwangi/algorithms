import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinations {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    final char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    
    public static void main(String[] args) {
        String digits = "24";
        LetterCombinations lc = new LetterCombinations();
        lc.letterCombinations(digits).forEach(x -> System.out.print(x+" "));
        System.out.println();
        lc.letterCombinations2(digits).forEach(x -> System.out.print(x+" "));
        System.out.println();
        lc.letterCombinations3(digits).forEach(x -> System.out.print(x+" "));
        System.out.println();
        lc.letterCombinations4(digits).forEach(x -> System.out.print(x+" "));
    }
    /**
     * Recursive
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        StringBuilder sb =  new StringBuilder();
        combine(res, digits, sb, 0);
        return res;
    }
    private void combine(List<String> res, String digits, StringBuilder sb, int posn) {
        if (posn ==  digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(posn) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            int sbLen = sb.length();
            combine(res, digits,sb.append(letters.charAt(i)), posn + 1);
            sb.setLength(sbLen);
        }
    }
    // Iterative
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }
    public static List<String> letterCombinations3(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.trim().isEmpty())
            return res;
        String map[] = new String [] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        StringBuilder sb = new StringBuilder();
        for (char dig: digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (char c : map[dig - '0'].toCharArray()) {
                for (String s: res) {
                    temp.add(sb.append(s).append(c).toString());
                    sb.setLength(0);
                }
            }
            res = new ArrayList<>(temp);
        }
        return res;
    }
    
    /**
     * Since each digit can possibly mean one of several characters, we'll need to create code that branches down the different paths as we iterate through the input digit string (D).
     *
     * This quite obviously calls for a depth-first search (DFS) approach as we will check each permutation of characters and store them in our answer array (ans). For a DFS approach we can use one of several options, but a recursive solution is generally the cleanest.
     *
     * But first, we'll need to set up a lookup table (L) to convert a digit to its possible characters. Since the digits are actually low-indexed integers, we can actually choose between an array or map/dictionary here with little difference.
     *
     * For our DFS function (dfs), we'll have to feed it the current position (pos) in D as well as the string (str) being built. The function will also need to have access to D, L, and ans.
     *
     * The DFS function itself is fairly simple. It will push a completed str onto ans, otherwise it will look up the characters that match the current pos, and then fire off new recursive functions down each of those paths.
     *
     * Once we're done, we should be ready to return ans.
     * @param D
     * @return
     */
    public List<String> letterCombinations4(String D) {
        int len = D.length();
        List<String> ans = new ArrayList<>();
        if (len == 0) return ans;
        bfs(0, len, new StringBuilder(), ans, D);
        return ans;
    }
    
    public void bfs(int pos, int len, StringBuilder sb, List<String> ans, String D) {
        if (pos == len) ans.add(sb.toString());
        else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for (int i = 0; i < letters.length; i++)
                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), ans, D);
        }
    }
}
