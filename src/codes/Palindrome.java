
public class Palindrome {

	public static void main(String[] args) {
		int x = 121;
		
		System.out.println(isPalindrome(x));
		String s = "madam";
		System.out.println(isPalindrome(s));
		String s1 = "babad";
		System.out.println(longestPalindrome(s1));
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
}
