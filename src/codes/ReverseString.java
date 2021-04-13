import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		String s = "James is working here";
		char[] chars = s.toCharArray();//{ 'H', 'E', 'L', 'L', 'O' };
		reverseString(chars);
		reverseStrIter(s);
		//System.out.println(reverseRecursively(s));
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
			c[k]=s.charAt(i);
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
}
