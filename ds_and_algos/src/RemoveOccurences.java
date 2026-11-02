/**
 * Remove all occurences of `AB` and `C` from a string
 *
 * The input string is 'CBAABCAB'
 *
 * The string after removal of 'AB' and 'C' is 'BA'
 *
 * 'CBAABCAB' —> 'C BA AB C AB' —> 'BA'
 *
 *
 * The input string is 'ABACB'
 *
 * The string after removal of 'AB' and 'C' is ''
 *
 * 'ABACB' —> 'AB A C B' —> 'AB' —> ''
 *
 *
 * The input string is 'ABCACBCAABB'
 *
 * The string after removal of 'AB' and 'C' is ''
 *
 * 'ABCACBCAABB' —> 'AB C A C B C A AB B' —> 'AB AB' —> ''
 */
public class RemoveOccurences {
    public static void main(String[] args) {
        String str = "ABCACBCAABB";
    
        str = remove(str);
        System.out.printf("The string after removal of 'AB' and 'C' is '%s'", str);
    }
    
    /**
     * The problem demands the removal of all adjacent as well as non-adjacent occurrences of string AB, i.e, for a given string, say
     * ADAABCB, after removing the first adjacent occurrence of AB (and C of-course), we get string ADAB which again needs to be
     * processed for adjacent AB. Therefore, the final output string will be AD
     * @param str
     * @return
     */
    static String remove(String str) {
        char[] chars = str.toCharArray();
        // `i` maintains the position of the current char in the input string.
        // `k` maintains the next free position in the output string.
        int i = 0, k = 0;
        // do till the end of the string is reached
        while (i < str.length()) {
            // if the current character is `B` and previous (need not be adjacent) was `A`, increment i and decrement `k`
            if (chars[i] == 'B' &&  (k > 0 && chars[k - 1] == 'A')) {
                --k;
                ++i;
            }
            // if the current character is `C`, increment `i`
            else if (chars[i] == 'C') {
                ++i;
            }
            // for any other character, increment both `i` and `k`
            else {
                chars[k++] = chars[i++];
            }
        }
        return new String(chars).substring(0, k);
    }
}
