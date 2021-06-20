
public class Palindrome {

	public static void main(String[] args) {
		int x = 121;
		
		System.out.println(isPalindrome(x));
		String s = "madam";
		System.out.println(isPalindrome(s));
		String s1 = "babad";
		System.out.println(longestPalindrome(s1));
		String s3 = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome3(s3));
		System.out.println(isPalindrome3(s));
	}
	
	public static boolean isPalindrome(int x) {
	    int temp = x,reversed=0;
		boolean isPalindrome = false;
		
		if(x < 0) {
			return isPalindrome;
		}
		while(x != 0) {
			reversed = reversed * 10 + x % 10;
			x = x/10;
		}
		
		if(temp == reversed) {
			isPalindrome = true;
		}
		return isPalindrome;
	}

	static boolean isPalindrome(String s) {
		if(s.isEmpty() || s.length() == 1) return true;

		int l = 0,r = s.length();
		if(s.charAt(l) != s.charAt(r-1)) return false;
		else {
			System.out.println(s.substring(l,r));
			return isPalindrome(s.substring(++l,--r));
		}
	}
	static String reverse(String s) {
		if(s == null || s.isEmpty()) return s;
		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() -1));
	}
	//Longest Palindrome
	//Start from the middle of a String
	static String longestPalindrome(String s){
		if(s == null || s.length() < 1)return "";
		//consider racecar and aabbaa
		int start = 0;
		int end = 0;
		for (int i=0; i < s.length();i++){
			int leng1 = expandFromTheMiddle(s,i,i); //case where racecar
			int leng2 = expandFromTheMiddle(s,i,i+1);//case where aabbaa
			int len = Math.max(leng1,leng2);
			if(len > end - start){
				start = i - ((len-1)/2);
				end = i+(len/2);
			}
		}
		return s.substring(start,end+1);

	}

	static int expandFromTheMiddle(String s,int left, int right){
		if(s == null || left > right)return 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left --;
			right++;
		}

		return right-left-1;
	}
	
	/**
	 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 *
	 *
	 *
	 * Example 1:
	 *
	 * Input: s = "A man, a plan, a canal: Panama"
	 * Output: true
	 * Explanation: "amanaplanacanalpanama" is a palindrome.
	 * Example 2:
	 *
	 * Input: s = "race a car"
	 * Output: false
	 * Explanation: "raceacar" is not a palindrome.
	 *
	 *
	 * Constraints:
	 *
	 * 1 <= s.length <= 2 * 105
	 * s consists only of printable ASCII characters.
	 */
	static boolean isPalindrome3(String s) {
		if (s.isEmpty()) return true;
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while (head < tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead))
				head++;
			else if (!Character.isLetterOrDigit(cTail))
				tail--;
			else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
					return false;
				head++;
				tail--;
			}
		}
		return true;
	}
	
	/**
	 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
	 *
	 * Example 1:
	 * Input: "aba"
	 * Output: True
	 * Example 2:
	 * Input: "abca"
	 * Output: True
	 * Explanation: You could delete the character 'c'.
	 * Note:
	 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
	 *
	 * Solution
	 * If the beginning and end characters of a string are the same (ie. s[0] == s[s.length - 1]), then whether the inner characters
	 * are a palindrome (s[1], s[2], ..., s[s.length - 2]) uniquely determines whether the entire string is a palindrome.
	 *
	 * Algorithm
	 * Suppose we want to know whether s[i], s[i+1], ..., s[j] form a palindrome. If i >= j then we are done.
	 * If s[i] == s[j] then we may take i++; j--. Otherwise, the palindrome must be either
	 * s[i+1], s[i+2], ..., s[j] or s[i], s[i+1], ..., s[j-1], and we should check both cases
	 */
	public boolean validPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i;
				return (isPalindromeRange(s, i+1, j) || isPalindromeRange(s, i, j-1));
			}
		}
		return true;
	}
	
	private boolean isPalindromeRange(String s, int i, int j) {
		for (int k = i; k <= i + (j - i) / 2; k++) {
			if (s.charAt(k) != s.charAt(j - k + i)) return false;
		}
		return true;
	}
	
	public boolean validaPalindrome2(String s) {
		if (s == null) {
			return true;
		}
		return helper(s, 0, s.length() - 1, false);
	}
	private boolean helper(String s, int h, int t, boolean deleted) {
		while (h < t) {
			if (s.charAt(h) != s.charAt(t)) {
				if (deleted) return false;
				return helper(s, h+1, t, true) || helper(s, h, t-1, true);
			}
			h++;
			t--;
		}
		return true;
	}
	
	public boolean validPalindrome3(String s) {
		if (s == null || s.length() == 0)
			return false;
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalin(s, left + 1, right) || isPalin(s, left, right - 1);
			}
			left++;
			right--;
		}
		return true;
	}
	private boolean isPalin(String s, int left, int right) {
		if (s == null || s.length() == 0) return false;
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) return false;
		}
		return true;
	}
	public static boolean isPalindrome4(String str)
	{
		if (str == null || str.length() == 0) {
			return false;
		}
		
		for (int i = 0, j = str.length() - 1; i < j; i++, j--)
		{
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	// Recursive function to check if `str[low…high]` is a palindrome or not
	public static boolean isPalindrome(String str, int low, int high)
	{
		// base case
		if (low >= high) {
			return true;
		}
		
		// return false if mismatch happens
		if (str.charAt(low) != str.charAt(high)) {
			return false;
		}
		
		// move to the next pair
		return isPalindrome(str, low + 1, high - 1);
	}
	// Recursive function to check if `str[low…high]` is a palindrome or not
	public static boolean isPalindrome5(String str, int low, int high)
	{
		return (low >= high) || (str.charAt(low) == str.charAt(high) &&
				isPalindrome5(str, low + 1, high - 1));
	}
	
}
