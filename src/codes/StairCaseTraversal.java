import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given two positive integers representing the height of a staircase and the maximum number of steps
 * that you can advance up the staircase at a time. Write a function that returns the number of ways in which you
 * can climb the staircase.
 *
 * For example, if you were given a staircase of height=3 and maxSteps=2 you could climb the staircase in 3 ways.
 * You could stake 1 step, then 1 step, you could also take 1 step, then 2 steps, and you could take 2 steps, then 1 step.
 *
 * Note the maxSteps <= height will always be true.
 *
 * Sample input:
 * height = 4
 * maxSteps = 2
 *
 * Sample output
 * 5
 * you can climb the staircase in the following ways:
 * 1,1,1,1
 * 1,1,2
 * 1,2,1
 * 2,1,1
 * 2,2
 *
 * Hint:
 * Think recursively: if you can advance 2 steps at a time, how many ways can you reach a staircase of height 1
 * and of height 2?
 *
 * Hint:
 * if you know the number of ways to climb a staircase of height 1 and of height 2, how many ways are there to climb
 * a staircase of height 3 (assuming the same max steps of 2)
 *
 * Hint
 * The number of ways to climb a staircase of height k with a max number of steps s is:
 * numWays[k-1] + numWays[k-2]+....+ numWays[k-2]. This is because if you can advance between 1 and s steps,
 * then from each step k-1, k-2,....,k-s, you can directly advance to the top of a staircase of height k. By adding the number
 * of ways to reach all the steps that you can directly advance to the top step from, you determine how many ways there are to
 * reach the top step.
 *
 * Optimal space & Time Complexity
 * O(n) time | O(n) space - where n is the height of the staircase.
 *
 */
public class StairCaseTraversal {
    
    public static void main(String[] args) {
        int height = 4, maxSteps = 2;
        System.out.println(stairCaseTraversal(height, maxSteps));
        System.out.println(stairCaseTraversal2(height, maxSteps));
        System.out.println(stairCaseTraversal3(height, maxSteps));
        System.out.println(stairCaseTraversal4(height, maxSteps));
    }
    public static int stairCaseTraversal(int height, int maxSteps) {
        return numWaysToTheTop(height, maxSteps);
    }
    private static int numWaysToTheTop(int height, int maxSteps) {
        if (height <= 1)
            return 1;
        
        int numWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numWays += numWaysToTheTop(height - step, maxSteps);
        }
        return numWays;
    }
    /**
     * Solution 2
     * O(n*k) time | O(n) space - where n is the height of the staircase and k the number of allowed steps
     */
    public static int stairCaseTraversal2(int height, int maxSteps) {
        HashMap<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return numberOfWaysToTheTop2(height, maxSteps, memoize);
    }
    
    private static int numberOfWaysToTheTop2(int height, int maxSteps, HashMap<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        
        int numWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numWays += numberOfWaysToTheTop2(height - step, maxSteps, memoize);
        }
        memoize.put(height, numWays);
        return numWays;
    }
    
    /**
     * O(n * k) time | O(n) space - where n is the height of the staircase and k is the number of allowed steps
     * @param height
     * @param maxSteps
     * @return
     */
    private static int stairCaseTraversal3(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;
        
        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currentHeight) {
                waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
                step +=1;
            }
        }
        return waysToTop[height];
    }
    
    /**
     *
     */
    public static int stairCaseTraversal4(int height, int maxSteps) {
        int numWays = 0;
        ArrayList<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);
        
        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;
            
            if (startOfWindow >= 0) {
                numWays -= waysToTop.get(startOfWindow);
            }
            
            numWays += waysToTop.get(endOfWindow);
            waysToTop.add(numWays);
        }
        
        return waysToTop.get(height);
    }
}
