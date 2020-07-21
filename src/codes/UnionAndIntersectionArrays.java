package codes;

import java.util.*;

/**
 *
 Union and Intersection of two sorted arrays

 Given two sorted arrays, find their union and intersection.

 Example:

 Input : arr1[] = {1, 3, 4, 5, 7}
 arr2[] = {2, 3, 5, 6}
 Output : Union : {1, 2, 3, 4, 5, 6, 7}
 Intersection : {3, 5}

 Input : arr1[] = {2, 5, 6}
 arr2[] = {4, 6, 8, 10}
 Output : Union : {2, 4, 5, 6, 8, 10}
 Intersection : {6}

 1) Use two index variables i and j, initial values i = 0, j = 0
 2) If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i.
 3) If arr1[i] is greater than arr2[j] then print arr2[j] and increment j.
 4) If both are same then print any of them and increment both i and j.
 5) Print remaining elements of the larger array.
 */
public class UnionAndIntersectionArrays {

    public static void main(String[] args) {

        int[]arr1 = {4,9,5};//{1, 2, 4, 5, 6};
        int[] arr2 = {9,4,9,8,4} ;//{2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;

        System.out.println(Arrays.toString(intersectionUnion(arr1,arr2,m,n)));
        System.out.println(Arrays.toString(intersection(arr1,arr2)));
        System.out.println(Arrays.toString(intersection2(arr1,arr2)));
    }

    static int[] intersectionUnion(int[]arr1, int[] arr2,int m,int n){
        int[] arr = new int[2];
        int i = 0;
        int j = 0;

        while (i < m && j < n){

            if(arr1[i] < arr2[j]){
               // i++;
                System.out.print(arr1[i++]+" ");
            }else  if(arr2[j] < arr1[i]){
                //j++;
                System.out.print(arr2[j++]+" ");
            }else{
                System.out.print(arr2[j++]+" ");
                i++;
            }

        }

        while(i < m)
            System.out.print(arr1[i++]+" ");
        while(j < n)
            System.out.print(arr2[j++]+" ");
        arr[0] = i;
        arr[1] = j;
        return arr;
    }


    /*
        Put each list into its own set to remove duplicates.
        Fill a new list with all elements in the second set that are also in the first set.
        Convert that list into an array and return it.
    */

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniques1 = new HashSet<>();
        for (int num: nums1) {
            uniques1.add(num);
        }
        Set<Integer> uniques2 = new HashSet<>();
        for (int num: nums2) {
            uniques2.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int num: uniques1) {
            if (uniques2.contains(num)) {
                result.add(num);
            }
        }
        int[] resultAsArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultAsArray[i] = result.get(i);
        }
        return resultAsArray;
    }

    public static int[] intersection2(int[] nums1, int[] nums2){

      if(nums1.length == 0 || nums2.length == 0){
            int[] arr = new int[0];
            return arr;
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();


        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        //set1.forEach(x->System.out.print(x+" "));
        int[] a = new int[set2.size()];
        int i = 0;
        for(int x : set2) {
            a[i] = x;
            i++;
        }
        return a;
    }
}
