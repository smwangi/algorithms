package greedy;

import java.util.Arrays;

/**
 * Greedy Algorithm are a class of algorithms that make a locally optimal choice at each stage with the hope of finding a global optimum.
 * They operate on the principle of take the best option now, without considering long term consequences.
 * Where used:
 * Used in optimization problems where the goal is to find the best solution from a set of candidate solutions.
 * Examples:
 * Fractional Knapsack Problem: You take fractions of items to maximize the total value of the knapsack.
 * Huffman Coding: Used for data compression where you assign variable-length codes to input characters based on their frequencies.
 * Dijkstra's Shortest Path Algorithm: Used to find the shortest path between nodes in a graph.
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        int[] weights = {10, 40, 20, 30};
        int[] values = {60, 40, 100, 120};
        int capacity = 50;
        System.out.println(FractionalKnapsack.getMaxValue(weights, values, capacity));

        System.out.println(minProductSubset(new int[] { -1, -1, -2, 4, 3 }, 5));
    }
    static class Item {
        int weight, value;
        Double cost;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            cost = (double) value / weight;
        }
    }

    static class FractionalKnapsack    {
        private static double getMaxValue(int[] weights, int[] values, int capacity)    {
            Item[] items = new Item[weights.length];

            for (int i = 0; i < weights.length; i++)    {
                items[i] = new Item(weights[i], values[i]);
            }

            Arrays.sort(items, (o1, o2) -> o2.cost.compareTo(o1.cost));

            double totalValue = 0d;
            for (Item i : items) {
                int currentWeight = Math.min(i.weight, capacity);
                double currentValue = i.cost * currentWeight;

                capacity -= currentWeight;
                totalValue += currentValue;

                if (capacity == 0) {
                    break;
                }
            }

            return totalValue;
        }
    }

    /**
     * Minimum Product subset of an array
     * Facts:
     * If there are even number of negative numbers and no zeros, the result is the product of all except the largest valued negative number.
     * If there are odd number of negative numbers and no zeros, the result is the product of all.
     * If there are zeros and positive, no negative the result is 0. The exceptional case is when there is no negative number and all other elements positive then our result should be the first minimum positive number,
     */
    static int minProductSubset(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }

        // Find count of negative numbers,
        // count of zeros, maximum valued
        // negative number, minimum valued
        // positive number and product of non-zero numbers
        int negMax = Integer.MIN_VALUE;
        int posMin = Integer.MAX_VALUE;
        int countNeg = 0, countZero = 0;
        int product = 1;

        for (int i = 0; i< n; i++) {
            // If number is 0, count it but don't multiply
            if (a[i] == 0) {
                countZero++;
                continue;
            }
            // Count negatives and keep track of maximum valued negative
            if (a[i] < 0) {
                countNeg++;
                negMax = Math.max(negMax, a[i]);
            }

            // Find minimum valued positive number
            if (a[i] > 0) {
                posMin = Math.min(posMin, a[i]);
            }
            product *= a[i];
        }

        // If they're all zeros or zero is present but no negative number is present
        if (countZero == n || (countNeg == 0 && countZero > 0)) {
            return 0;
        }

        // If all are positive
        if (countNeg == 0) {
            return posMin;
        }

        // If they're even number except zero of negative numbers
        if (countNeg % 2 == 0 && countNeg != 0) {
            // Otherwise result is product of all non-zeros divided by maximum valued negative.
            product = product / negMax;
        }

        return product;
    }
}
