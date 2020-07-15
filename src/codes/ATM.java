package codes;

/**
 * There is enough money available on ATM in nominal value 10, 20, 50, 100, 200 and 500 dollars.
 *
 * You are given money in nominal value of n with 1<=n<=1500.
 *
 * Try to find minimal number of notes that must be used to repay in dollars, or output -1 if it is impossible.
 */
public class ATM {

    public static void main(String[] args) {

      minimalNotes(238);
       //System.out.println( solve1(560));
       System.out.println( solve(560));
    }
    static int minimalNotes(int n){
        //int minimal = Integer.MAX_VALUE;
        if(n%10 != 0)
            return -1;
        int[] denom = {10,20,50,100,200,500};
        int l = 0,r = denom.length-1;
        int count = 0;

        while (n > 0 ){
            if(r < 0){
              break;
            }
            int temp = denom[r];
           // System.out.println("n: "+n+" - temp:"+temp);
            if(n > temp){
                n = n - temp;//011 091 014 116 00
                count ++;
                //r--;
            }else if(n == temp){
                count++;
                break;
            }else if( n < temp){
                r--;
            }else{
                //count = -1;
            }
        }
        System.out.println(" - count:"+count);
        return count;
    }

    static int solve1(int n){
        int[] denominations = new int[]{500, 200, 100, 50, 20, 10};
        int result = 0;

        for (int denomination: denominations) {
            result += n / denomination;
            n %= denomination;
            System.out.println(n);
        }

        return n == 0 ? result : -1;
    }

    static int solve(int n) {
        int notes = 0;
        for (int bill : new int[] {500, 200, 100, 50, 20, 10}) {
            notes += n / bill;
            n %= bill;
        }
        return n == 0 ? notes : -1;
    }
}
