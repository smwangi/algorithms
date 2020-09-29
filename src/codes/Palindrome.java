package codes;

public class Palindrome {

	public static void main(String[] args) {
		int x = 121;
		
		System.out.println(isPalindrome(x));
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
}
