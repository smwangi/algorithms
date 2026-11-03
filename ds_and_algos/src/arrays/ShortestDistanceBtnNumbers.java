package arrays;

public class ShortestDistanceBtnNumbers {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int x = 3;
        int y = 6;
        System.out.println("Minimum distance between " + x + " and " + y + " is " + shortestDistance(arr, x, y));
    }
    static int shortestDistance(int[] arr, int x, int y) {
        int minDistance = Integer.MAX_VALUE;
        // Stores the index of the previous occurrence of x or y.
        int prev = -1;
        int i;

        for (i = 0; i < arr.length; i++) {
            if (arr[i] == x || arr[i] == y) {
                // Check if prev != -1.
                // If prev is not equal to -1 and the current element is not equal to the element at index prev,
                if (prev != -1 && arr[i] != arr[prev]) {
                    minDistance = Math.min(minDistance, i - prev);
                }
                // Update prev to current index.
                prev = i;
            }
        }
        return minDistance;
    }
}
