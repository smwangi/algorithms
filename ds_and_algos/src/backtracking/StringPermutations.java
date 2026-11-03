package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all permutations of a string with distinct characters.
 *
 * Input: "ABC"
 * Output: ABC, ACB, BAC, BCA, CAB, CBA
 */
public class StringPermutations {

    /**
     * Keep one character fixed and calculate the permutations of the others: move each character of
     * the remaining string onto the prefix in turn, and recurse on what is left.
     */
    public static List<String> prefix(String s) {
        List<String> result = new ArrayList<>();
        prefix("", s, result);
        return result;
    }

    private static void prefix(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            prefix(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }

    // Swap each later character into the current index, recurse on the next index, then swap back.
    public static List<String> bySwapping(String s) {
        List<String> result = new ArrayList<>();
        bySwapping(s.toCharArray(), 0, result);
        return result;
    }

    private static void bySwapping(char[] ch, int currentIndex, List<String> result) {
        if (currentIndex >= ch.length - 1) {
            result.add(String.valueOf(ch));
            return;
        }
        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            bySwapping(ch, currentIndex + 1, result);
            swap(ch, currentIndex, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Permute everything after the first character, then insert the first character at every position of each.
    public static List<String> insertFirst(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 2) {
            result.add(s);
            return result;
        }
        for (String permutation : insertFirst(s.substring(1))) {
            for (int i = 0; i <= permutation.length(); i++) {
                result.add(permutation.substring(0, i) + s.charAt(0) + permutation.substring(i));
            }
        }
        return result;
    }

    /**
     * Iterative version of insertFirst, using a list of partial permutations.
     * Start with the first character, then for every next character, take each partial permutation
     * and insert the character at all possible positions.
     */
    public static List<String> iterative(String s) {
        List<String> partial = new ArrayList<>();
        if (s.isEmpty()) {
            partial.add(s);
            return partial;
        }
        partial.add(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            // iterate backwards so removing from the list doesn't skip entries
            for (int j = partial.size() - 1; j >= 0; j--) {
                String str = partial.remove(j);
                for (int k = 0; k <= str.length(); k++) {
                    partial.add(str.substring(0, k) + s.charAt(i) + str.substring(k));
                }
            }
        }
        return partial;
    }
}
