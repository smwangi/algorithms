package searching;

/**
 * Given a sorted array and a key, return the index of the key, or -1 if it is not present.
 *
 * A linear search compares the key with every element, which is O(n). Because the array is sorted,
 * binary search can instead compare the key with the middle element; if they are unequal, the half in
 * which the key cannot be is eliminated, and the search continues on the remaining half. If the search
 * ends with the remaining half being empty, the key is not in the array. O(log n).
 *
 * Remember – the key aspect here is that the array is already sorted.
 */
public class BinarySearch {

    public static int iterative(int[] sorted, int key) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            // l + (r - l) / 2 rather than (l + r) / 2, which can overflow for large indexes
            int mid = l + (r - l) / 2;
            if (sorted[mid] == key)
                return mid;

            if (key > sorted[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int recursive(int[] sorted, int key) {
        return recursive(sorted, key, 0, sorted.length - 1);
    }

    private static int recursive(int[] sorted, int key, int l, int r) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (key == sorted[mid])
            return mid;
        // If key is smaller than mid, then it can only be present in the left half
        if (key < sorted[mid])
            return recursive(sorted, key, l, mid - 1);
        return recursive(sorted, key, mid + 1, r);
    }
}
