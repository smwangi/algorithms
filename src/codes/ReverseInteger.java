
public class ReverseInteger {

	public static void main(String[] args) {
		
		System.out.println(reverse(-2147483412));
	}
	
	public static int reverse(int x) {
		int reversed = 0;
		
		  boolean isNegative = x < 0 ? true:false;
	        
	       
	        System.out.println(x);
	        System.out.println(Integer.MAX_VALUE);
	        if(Integer.MIN_VALUE < x && x < Integer.MAX_VALUE/2 ) {
	        	while(x != 0) {
	    			reversed = reversed * 10 + x % 10;//last digit
	    			x = x/=10;
	    		}
	        }
	        if(isNegative){
	           // x = x *-1;
	        }
		
		 return reversed;//isNegative == true ? reversed * -1:reversed;
	}
}
