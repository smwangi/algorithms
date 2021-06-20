import java.util.Arrays;
import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		String s = "James is working here";
		char[] chars = s.toCharArray();//{ 'H', 'E', 'L', 'L', 'O' };
		reverseString(chars);
		reverseStrIter(s);
		reverse(s.toCharArray(), 0, s.length() - 1);
		//System.out.println(reverseRecursively(s));
		
		String s2 = "preparation Interview Technical for material " +
				"good provide We";
		
		s2 = reverse2(s2);
		System.out.println(s2);
	}

	public static void reverseString(char[] chars) {

		int right = chars.length-1;
		int left = 0;


		while(left < right) {
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
		
		System.out.println(Arrays.toString(chars));
	}

	static void reverseStrIter(String s) {
		char[] c = new char[s.length()];
		StringBuilder sb = new StringBuilder(s.length());
		int k = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			c[k] = s.charAt(i);
			k++;
			sb.append(s.charAt(i));
		}
		System.out.println(String.valueOf(c));
		System.out.println(sb.toString());
	}
	
	static String reverseRecursively(String s) {
		if(s.length() < 2) return s;
		
		return reverseRecursively(s.substring(1) + s.charAt(0));
	}
	// Recursive function to reverse a given string
	public static void reverse(char[] c, int l, int h)
	{
		if (l < h)
		{
			swap(c, l, h);
			reverse(c, l + 1, h - 1);
		}
	}
	static void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	/**
	 * Reverse text without reversing individual words
	 * Input:  We provide good material for Technical Interview preparation
	 *
	 * Output: preparation Interview Technical for material good provide We
	 *
	 * Push individual words from the beginning into a stack. Then pop all the words from the stack and store them
	 * back into the text in LIFO order. The time complexity is O(n) and requires O(n) extra space for the stack, where
	 * n is the length of the given text.
	 */
	static String reverse2(String s) {
		int low = 0, high = 0;
		// create an empty stack
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			// if space is found, we found a word
			if (s.charAt(i) == ' ') {
				// push each word in the stack
				stack.push(s.substring(low, high + 1));
				// reset `low` and `high` for the next word
				low = high = i + 1;
			} else {
				high = i;
			}
		}
		// push the last word into the stacj
		stack.push(s.substring(low));
		// construct the string by following the LIFO order
		StringBuilder sb = new StringBuilder();
		while (!stack.empty())
			sb.append(stack.pop()).append(' ');
		
		return sb.substring(0, sb.length() - 1);// remove the last space
	}
	/**
	 * Improving complexity
	 *
	 * The idea is to in-place reverse each word present in the input text and finally reverse the whole text to get the
	 * desired output
	 *
	 * Input text: preparation Interview Technical for material good provide We
	 *
	 * 1. Reverse each word:
	 * noitaraperp weivretnI lacinhceT TI rof lairetam doog edivorp eW
	 *
	 * 2. Reverse the whole text:
	 * We provide good material for Technical Interview preparation
	 */
	
	
	// Utility function to reverse subarray `chars[begin…end]`
	public static void reverse5(char[] chars, int begin, int end)
	{
		while (begin < end) {
			swap(chars, begin++, end--);
		}
	}
	
	// Function to reverse a text without reversing the individual words.
	public static void reverse5(char[] chars)
	{
		// `chars[low…high]` forms a word
		int low = 0, high = 0;
		
		// scan the text
		for (int i = 0; i < chars.length; i++)
		{
			// if space is found, we found a word
			if (chars[i] == ' ')
			{
				// reverse the found word
				reverse(chars, low, high);
				
				// reset `low` and `high` for the next word
				low = high = i + 1;
			}
			else {
				high = i;
			}
		}
		
		// reverse the last word
		reverse5(chars, low, high);
		
		// reverse the whole text
		reverse5(chars, 0, chars.length - 1);
	}
}
