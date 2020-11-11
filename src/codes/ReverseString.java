import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		String s = "James is working here";
		char[] chars = s.toCharArray();//{ 'H', 'E', 'L', 'L', 'O' };
		reverseString(chars);
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

}
