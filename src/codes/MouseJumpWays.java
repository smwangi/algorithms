/**
 * A mouse is looking over a river that's 21 feet wide. There are 20 stones placed in the river 1 foot apart,
 * such that there is 1 foot from the beginning of the river to the first stone, and 1 foot from the first stone
 * to the next stone, and so on; and 1 foot from the last stone to the end of the river. The mouse can jump
 * over 1 foot or 2 feet such that the first step the mouse can make is either from the beginning of the
 * river to the first stone, or from the beginning of the river to the second stone. If the mouse can't jump
 * backwards, write a Java function that returns the number of different ways the mouse can jump from
 * the beginning of the river to the end of the river.
 */
public class MouseJumpWays {
    public static void main(String[] args) {

        int n = 21;
        System.out.println(numOfWays(n));
    }

    /**
     * Using dynamic programming.
     * The mouse can either n-1 or n-2 jumps (1 foot or 2 feet)
     * The distance to jump is 21 feet
     * @param n
     * @return
     */
    static int numOfWays(int n){

     if (n == 1 ) return  1;
     int[] ways = new int[n];
     ways[0] = 1;
     ways[1] = 2;
     for(int i = 2; i < n;i++){
         ways[i] = ways[i-2] + ways[i-1];
     }
     return ways[n-1];
    }
}
