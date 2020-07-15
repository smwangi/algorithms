import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {

		char[] chars = { 'H', 'E', 'L', 'L', 'O' };
		reverseString(chars);
	}

	public static void reverseString(char[] chars) {

		int right = chars.length-1;
		int left = 0;

		/*
		 * for(int i=0;i < chars.length; i++) {
		 * 
		 * if(chars[i] == ' '){ right = i -1; System.out.println(right);
		 * reversePartOfCharArr(chars,left,right); left = i+1; } }
		 */
		//reversePartOfCharArr(chars, left, chars.length-1);
		while(left < right) {
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
		
		System.out.println(Arrays.toString(chars));
	}

	/* private static void reversePartOfCharArr(char[] arr, int l, int r) {

		while (l < r) {

			char temp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = temp;

		}
	} */
}
