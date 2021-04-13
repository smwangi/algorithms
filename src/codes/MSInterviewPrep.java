import java.util.*;

public class MSInterviewPrep {
    
    public static void main(String[] args) {
        ArrayQuestions arrayQuestions = new ArrayQuestions();
        int[] nums = {1, 2, 4, 5, 6};
       System.out.println(arrayQuestions.missingNumber(nums));
       System.out.println(arrayQuestions.getMissingNumber(nums));
       System.out.printf("Duplicate number %d: ", arrayQuestions.duplicateNumber());
       System.out.println();
       System.out.println("Min Max "+ Arrays.toString(arrayQuestions.smallestAndLargest()));
       arrayQuestions.pairSum();
       arrayQuestions.printPairs();
       String s = "abcabcbb";
       System.out.println(arrayQuestions.longestStringWithoutRepeatingCharacters(s));
       String palindrome = "madam";
       System.out.println(arrayQuestions.recursionPalindrome(palindrome));
       int[] inputArray = {-2, 2, 5, -11, 6};
       System.out.println("Max Sum: "+arrayQuestions.arrayMaxConsecutiveSum(inputArray));
       int[] arrToSort = {5, 2, 8, 7, 1};
       System.out.println(Arrays.toString(arrayQuestions.sortArray(arrToSort)));
       int[] removeEl = {0,1,2,2,3,0,4,2}; int val = 2;
       System.out.println(arrayQuestions.removeElements(removeEl, val));
       int[] move = {0, 1, 0, 3, 12};
       arrayQuestions.moveElements(move);
       int[] dups = {12, 1, 3, 12, 12, 4, 13};
       System.out.println(arrayQuestions.findDups(dups));
       System.out.println(arrayQuestions.findDups2(dups));
       int[] dupLs = {4,3,2,7,8,2,3,1};
       arrayQuestions.findDuplicates(dupLs);
       int[] disapNums = {4,3,2,7,8,2,3,1};
       arrayQuestions.findDisappearedNumber(disapNums);
       int[] sortedSquareArr = {-6, -4, 1, 2, 3, 5};
       arrayQuestions.sortedSquaredArray(sortedSquareArr);
       int[] rotateArr = {1,2,3,4,5,6,7}; int k = 3;
       arrayQuestions.rightRotateArray(rotateArr, k);
       arrayQuestions.rotate(rotateArr, k);
       int[] mvZeros = {0,1,0,3,12};
       arrayQuestions.moveZeros(mvZeros);
       int[] smallestLen = {1, 2, 3, 4, 5, 6, 7, 8};
       arrayQuestions.smallesSubArrayLength(smallestLen, 20);
       int[] distinctElements = {5, 2, 3, 5, 4, 3};
       ArrayQuestions.calculate(distinctElements);
       int[] givenSum = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
       arrayQuestions.subArrayHavingGivenSum(givenSum, 15);
    
        int[] findSubArr2 = { 0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10 };
        int sum = 15;
        arrayQuestions.findSubArray2(findSubArr2, sum);
        Integer[] maxSum = { 4, 6, 2, 7, 9, 8 };
        arrayQuestions.findMaximum(maxSum);
        
    }
}
class ArrayQuestions {
    //Misssing number 1 to 100
    int  missingNumber(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return 0;
    }
    /**
     * Java method to find missing number in array of size n containing
     * numbers from 1 to n only.
     * can be used to find missing elements on integer array of
     * numbers from 1 to 100 or 1 - 1000
     * n(n+1)/2
     */
    int getMissingNumber(int[] nums) {
        int expectedSum = 6 * ((6 + 1) / 2);
        System.out.println("Expected Sum: "+expectedSum);
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }
        
        return expectedSum - actualSum;
    }
    //Single number
    int duplicateNumber() {
        int[] nums = {1, 2, 2, 3, 4, 5};
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(set.contains(i)) return i;
            set.add(i);
        }
        return 0;
    }
    
    int[] smallestAndLargest() {
        int[] nums = { 10, 4, 9, 18, 21, 2};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        for(int i : nums) {
            if(i < min) min = i;
            if(i > max) max = i;
        }
        result[0] = min;
        result[1] = max;
        return result;
    }
    
    //time complexity O(n^2)
    Map<Integer, Integer> pairSum() {
        int[] nums = {2, 7, 6, 3, 5, 4, 8, 1, 10, 9};
        int sum = 9;
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == sum) {
                    pairs.put(nums[i], nums[j]);
                }
            }
        }
        for(Map.Entry entry : pairs.entrySet()) {
            System.out.println(entry.getKey()+" <> "+entry.getValue());
        }
        return pairs;
    }
    
    void printPairs() {
        int[] nums = {2, 7, 6, 3, 5, 4, 8, 1, 10, 9};
        int sum = 9;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            int target = sum - i;
            if(!set.contains(target))
                set.add(i);
            else System.out.println("i, j"+i +" <> "+target);
        }
    }
    
    int longestStringWithoutRepeatingCharacters(String s ) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        
        while (right <= s.length()-1 ) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }
        System.out.println(left+" <> "+right+" STR: "+s.substring(left,right));
        return max;
    }
    
    boolean recursionPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) return true;
        int l = 0, r = s.length();
        if(s.charAt(l) != s.charAt(r-1))return false;
        else {
            return recursionPalindrome(s.substring(++l, --r));
        }
    }
    
    //Kadane's algorithm ()
    int arrayMaxConsecutiveSum(int[] inputArray) {
        int max_sum = inputArray[0];
        int current_sum = max_sum;
        for (int i = 1; i < inputArray.length; i++) {
            current_sum = Math.max(inputArray[i] + current_sum, inputArray[i]);
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }
    
    /**
     * Algorithm
     * STEP 1: START
     * STEP 2: INITIALIZE arr[] ={5, 2, 8, 7, 1 }.
     * STEP 3: SET temp =0
     * STEP 4: PRINT "Elements of Original Array"
     * STEP 5: REPEAT STEP 6 UNTIL i<arr.length
     *             //for(i=0; i<arr.length; i++)
     * STEP 6: PRINT arr[i]
     * STEP 7: REPEAT STEP 8 to STEP 9 UNTIL i<arr.length
     *             //for(i=0; i<arr.length; i++ )
     * STEP 8: REPEAT STEP 9 UNTIL j<arr.length
     *             //for(j=i+1;j<arr.length;j++)
     * STEP 9: if(arr[i]>arr[j]) then
     *             temp = arr[i]
     *             arr[i]=arr[j]
     *             arr[j]=temp
     * STEP 10: PRINT new line
     * STEP 11: PRINT "Elements of array sorted in ascending order"
     * STEP 12: REPEAT STEP 13 UNTIL i<arr.length
     *             //for(i=0;i<arr.length;i++)
     * STEP 13: PRINT arr[i]
     * STEP 14: END
     * @param arr
     * @return
     */
    int[] sortArray(int[] arr) {
        int[] tempArr = new int[arr.length];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    
    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
     * extra memory.
     *
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *
     * Clarification:
     *
     * Confused why the returned value is an integer but your answer is an array?
     *
     * Note that the input array is passed in by reference, which means a modification
     * to the input array will be known to the caller as well.
     *
     * Internally you can think of this:
     *
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeElement(nums, val);
     *
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2]
     * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
     * It doesn't matter what you leave beyond the returned length. For example if you return 2 with
     * nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
     * Example 2:
     *
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3]
     * Explanation: Your function should return length = 5, with the first five elements of
     * nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary.
     * It doesn't matter what values are set beyond the returned length.
     *
     *
     * Constraints:
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     * @param nums
     * @param val
     * @return
     */
    int removeElements(int[] nums, int val) {
    
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
    
    void moveElements(int[] nums) {
        int n = nums.length;
        int pos =0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while (pos < n) nums[pos++] =0;
        System.out.println("Moved: "+Arrays.toString(nums));
    }
    
    /**
     * Approach 1: Sorting
     * Intuition
     *
     * If the numbers are sorted, then any duplicate numbers will be adjacent in the sorted array.
     *
     * Algorithm
     *
     * Given the intuition, the algorithm follows fairly simply. First,
     * we sort the array, and then we compare each element to the previous element.
     * Because there is exactly one duplicated element in the array, we know that the array is of at
     * least length 2, and we can return the duplicate element as soon as we find it.
     *
     * Time complexity : \mathcal{O}(nlgn)O(nlgn)
     *
     * The sort invocation costs \mathcal{O}(nlgn)O(nlgn) time in Python and Java, so it dominates the subsequent linear scan.
     *
     * Space complexity : \mathcal{O}(1)O(1) (or \mathcal{O}(n)O(n))
     *
     * Here, we sort nums in place, so the memory footprint is constant. If we cannot modify the input array, then we must
     * allocate linear space for a copy of nums and sort that instead.
     * @param nums
     * @return
     */
    int findDups(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
    
    int findDups2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return nums[i];
            else set.add(nums[i]);
        }
        return -1;
    }
    
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int negIdx = Math.abs(nums[i]) - 1;
            if(nums[negIdx] < 0) {
                dups.add(Math.abs(negIdx+1));
            }
            nums[negIdx] = - nums[negIdx];
        }
        dups.forEach(x -> System.out.print(x+" "));
        return dups;
    }
    
    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     * Example 2:
     *
     * Input: nums = [1,1]
     * Output: [2]
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     *
     * The solution works because 1 ≤ a[i] ≤ n (n = size of array)
     * As we walk through all elements in the array, we can use the current element as an index
     * and flag its value (in place). All numbers are > 0, so we can use a negative number.
     * In the end, the indexes of all positive numbers in the array are the missing values.
     *
     * The input: [4, 3, 2, 7, 8, 2, 3, 1]
     * Becomes: [-4, -3, -2, -7, 8, 2, -3, -1]
     *
     * Starting from 1, the missing values are 5 and 6.
     */
    List<Integer> findDisappearedNumber(int[] nums) {
        //System.out.println();
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0)
                nums[index - 1] *= -1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        /*Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1] )continue;
            else if(nums[i + 1] - nums[i] != 1)
              res.add(nums[i] + 1);
        }*/
        res.forEach(x -> System.out.print("Disap Nums: "+x+" "));
        return res;
    }
    
     int[] sortedSquaredArray(int[] nums) {
        int[] output = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        for (int i = nums.length -1 ; i >= 0; i--) {
            if (Math.abs(nums[l]) > nums[r]) {
                output[i] = nums[l] * nums[l];
                l++;
            } else {
                output[i] = nums[r] * nums[r];
                r--;
            }
        }
        System.out.println(Arrays.toString(output));
        return output;
    }
    
    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     * We need to think about the relationship between the new location and the original — how to calculate?
     * We can start with the last element in the above example. 7 (was at index 6) is rotated in 3 steps, the final location is at index 2.
     * We can think it as we push 7 to a new array, and the new idx is 9 (the overall location starting from 0):
     * idx:     0  1  2  3  4  5  6                   7  8   9  10 11 12 13
     * old array: [] [] [] [] [] [] [7] -> new array: [] [] [7] [] [] [] []
     *
     * So, no matter how far it was pushed away, we can always find it’s relative index between (0–6) through % n (arrays’ length) operation.
     *
     * Using Extra Array
     * Algorithm
     *
     * We use an extra array in which we place every element of the array at its correct position i.e. the number
     * at index ii in the original array is placed at the index (i + k) \% \text{ length of array}(i+k)% length of array.
     * Then, we copy the new array to the original one.
     */
    void rightRotateArray(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = (i + k)%nums.length;
            System.out.println("i+k % nums.length Ans: "+ val+" nums[i]"+nums[i]+" i "+i+" k "+k+" i+k % nums.length "+i+k+nums.length);
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(temp));
    }
    void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println("Rotated Arr: "+nums);
    }
    void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    int[] moveZeros(int[] nums) {
    
        if (nums.length == 0 || nums == null) return nums;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[idx++] = nums[i];
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    
    /**
     * This method sort the integer array using bubble sort algorithm
    */
    void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length -1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void mergeSort(int[] input, int start, int end) {
        // break problem into smaller structurally identical problems
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
        }
        
        //Merge solved pieces to get solution to original problem
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];
        
        while (first <= mid) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
    
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }
    
    /**
     * Find All Numbers Disappeared in an Array
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] arr = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - 1] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
    
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] arr = new int[nums.length+1];
        List<Integer> ans = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (arr[now] == 0)
                arr[now] = i+1;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                ans.add(i);
        }
        
        return ans;
    }
    
    /**
     * Approach #2 HashSet [Accepted]
     * Intuition
     *
     * A brute force method for solving this problem would be to simply check for the presence of each number
     * that we expect to be present. The naive implementation might use a linear scan of the array to check for containment,
     * but we can use a HashSet to get constant time containment
     *
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that
     * is missing from the array.
     *
     * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     *
     * Example 1:
     *
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
     * in the range since it does not appear in nums.
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number
     * in the range since it does not appear in nums.
     * Example 3:
     *
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number
     * in the range since it does not appear in nums.
     * Example 4:
     *
     * Input: nums = [0]
     * Output: 1
     * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number
     * in the range since it does not appear in nums.
     */
    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        
        int expectedNumCount = nums.length + 1;
        for (int num = 0; num < expectedNumCount; num++) {
            if (!numSet.contains(num))
                return num;
        }
        return -1;
    }
    
    /**
     * Find the smallest subarray length whose sum of elements is greater than `k`
     * @param nums
     * @param k
     * @return
     */
    int smallesSubArrayLength(int[] nums, int k) {
    
        //Stores the result
        int len = Integer.MAX_VALUE;
        //Stores Current Window Sum
        int windowSum = 0;
        //Stores the window starting point
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            //include the current element in the window
            windowSum += nums[r];
            //Window becomes unstable if its sum becomes more than `k`
            while (windowSum > k && l <= r) {
        //update the result if the current window's length is less than the minumum found so far
                len = Integer.min(len, r - l + 1);
                //remove elements from the window's left side till the window becomes stable again
                windowSum -= nums[l];
                l++;
            }
        }
        
        System.out.println("Smallest Window Len: "+len+ " l "+l+" r ");
        return len;
    }
    
    /**
     * Print all subarrays having distinct elements
     * Given an integer array, print all maximum size subarrays having all distinct elements in them
     * Example
     * A[] = {5, 2, 3, 5, 4, 3}
     *
     * We can use a sliding window to solve this problem easily. The idea is to maintain a window with an invariant that all elements
     * inside it must be distinct. The solution keeps on expanding the window to the right, and if any duplicate is encountered, it
     * shrinks the window from the left until all elements are distinct again. To keep track of distinct elements inside a window, use a map
     *
     */
    public static void printSubArray(int[] arr, int i, int j, int n) {
        if (i < 0 || i > j || j >= n) {
            return;
        }
        for (int index = i; index < j; index++) {
            System.out.print(arr[index]+", ");
        }
        System.out.println(arr[j]);
    }
    //function to print all subarrays having distinct elements
    public static void calculate(int[] arr) {
        int n = arr.length;
        //Create a map to mark elements as visited in the current window
        Map<Integer, Boolean> visited = new HashMap<>();
        //put all elements on a map
        for (int val : arr) {
            visited.put(val, false);
        }
        //points to the left and right boundary of the current window, i.e, the current window is formed by `arr[left, right]`
        int right = 0, left = 0;
        
        //loop until the right index of the current window is less than the maximum index
        while (right < n) {
            //keep increasing the window size if all elements in the current window are distinct
            while (right < n && !visited.get(arr[right])) {
                visited.put(arr[right], true);
                right++;
            }
            printSubArray(arr, left, right - 1, n);
            //As soon as a duplicate is founf (`arr[right]`), terminate the above loop, and reduce the window's size from
            //its left to remove the duplicate
            while (right < n && visited.get(arr[right])) {
                visited.put(arr[left], false);
                left++;
            }
        }
    }
    
    /**
     * Input:  {2, 6, 0, 9, 7, 3, 1, 4, 1, 10}, sum 15
     * Output: Subarray {6, 0, 9} exists with sum 15
     *
     *
     * Input:  {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, sum 15
     * Output:
     *
     * Subarray {1, -4, 7, 6, 1, 4} exists with sum 15
     * or
     * Subarray {4, 1, 10} exists with sum 15
     *
     *
     * Input:  {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, sum -3
     * Output: Subarray {1, -4} exists with sum -3
     *
     * Sliding Window
     * Idea is to maintain a window that starts from the current element, and the sum of its elements is more than or
     * equal to the given sum. If the current window's sum becomes less than the given sum, then the window is unstable, and we keep
     * on adding elements to the current window from its right till the window becomes stable again. Print the window if its sum
     * is equal to the given sum at any point. Note this approach will only work with an array of positive integers.
     */
    void subArrayHavingGivenSum(int[] arr, int sum) {
    
        //Maintains the sum of the current window
        int windowSum = 0;
        
        //maintain a window `[low, high - 1]`
        int high = 0;
        
        //consider every subarray starting from the `low` index
        for (int low = 0; low < arr.length; low++) {
            //if the current window's sum is less than the given sum then add elements to the current window from the right
            while (windowSum < sum && high < arr.length) {
                windowSum += arr[high++];
            }
            
            //if the current window's sum is equal to the given sum
            if (windowSum == sum) {
                System.out.printf("Sub Array found [%d - %d] ",low, high -1);
            }
            
            //At this point, the current window's sum is more than the given sum.
            //Remove the current element (leftmost elements) from the window
            windowSum -= arr[low];
        }
        System.out.println();
    }
    
    /**
     * Using Hashing
     * The above solution will fail for negative numbers. We can use hashing to check if a subarray with the given sum exists in the array or
     * not. The idea is to traverse the given array and maintain the sum of elements seen so far. if the difference between the current
     * sum and the given sum is seen before (i.e the difference exists in the set), return true as there is at least one subarray with the
     * given sum that ends at the current index; otherwise, insert the sum into the set
     *
     *  Function to check if subarray with the given sum exists in
     *  the array or not
     */
    public static boolean findSubArray(int[] arr, int sum) {
        //Create an empty set
        Set<Integer> set = new HashSet<>();
        
        //Insert number 0 into the set to handle the case when a subarray with the given sum starts from index 0
        set.add(0);
        
        //Keep track of the sum of elements so far
        int sum_so_far = 0;
        
        //traverse the given array
        for (int i : arr) {
            //update `sum_so_far`
            sum_so_far += i;
            
            // if `sum_so_far` is seen before, we have found the subarray with sum `sum`
            if (set.contains(sum_so_far - sum))
                return true;
            
            //Otherwise, search the sum of elements so far in the set
            set.add(sum_so_far);
        }
        
        // we reach here when no subarray exists
        return false;
    }
    
    /**
     * function to print subarray having a given sum using hashing
     *
     */
    void findSubArray2(int[] arr, int sum) {
        //Create an empty map
        Map<Integer, Integer> map = new HashMap<>();
        
        //Insert `(0, -1)` pair into the set to handle the case when a sub array with the given sum starts from index 0
        map.put(0, -1);
        
        // keep track of sum of elements so far
        int sum_so_far = 0;
        
        //traverse the given array
        for (int i = 0; i < arr.length; i++) {
            // update `sum_so_far`
            sum_so_far += arr[i];
            
            // `if sum_so_far - sum` is seen before, we have found the subarray with sum `sum`
            if (map.containsKey(sum_so_far - sum)) {
                System.out.print("Subarray Found ["+ (map.get(sum_so_far - sum) + 1) + "_" + i + "]");
                return;
            }
            
            //insert (current sum, current index) pair into the map
            map.put(sum_so_far, i);
        }
        System.out.println();
    }
    
    /**
     * Input:
     *
     * first[] = { 1, 8, 10, 12 }
     * second[] = { 2, 4, 9, 15 }
     * sum = 11
     *
     * Output: The closest pair is [1, 9]
     *
     *
     * Input:
     *
     * first = { 10, 12, 15, 18, 20 }
     * second = { 1, 4, 6, 8 }
     * sum = 22
     *
     * Output: The closest pair is [18, 4]
     *
     * Given two sorted arrays, find a pair whose sum is closest to a given sum where the pair consists of
     * elements from each array.
     */
    void findClosestPair(int[] first, int[] second, int sum) {
        // `x` and `y` point to the indexes of the closest pair found so far
        int x = 0, y = 0;
        
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                //update the closest pair if the current pair `(i, j)` is more closer to `sum`
                if (Math.abs(first[i] + second[j] - sum) < Math.abs(first[x] + second[y] - sum)) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.printf("The closest pair is [%d, %d]",first[x], second[y]);
        System.out.println();
    }
    
    /**
     * find two numbers with maximum sum formed by array digits
     *
     * Given an integer array between 0 and 9 find two numbers with maximum sum formed using all the array digits. The difference in the number
     * of digits of the two numbers should be +- 1.
     *
     * Input:  { 4, 6, 2, 7, 9, 8 }
     * Output: The two numbers with maximum sum are 974 and 862
     *
     *
     * Input:  { 9, 2, 5, 6, 0, 4 }
     * Output: The two numbers with maximum sum are 952 and 640
     *
     * The idea is to sort the given array in descending order and construct two numbers x and y by picking alternate digits from the array
     * where x is filled with digits at the odd indices, y is fulled with the digits at the even index of the sorted array.
     *
     */
    void findMaximum(Integer[] input) {
        //Sort the array in descending order
        Arrays.sort(input, Comparator.reverseOrder());
        
        // fill `x` with digits at the odd indices of the sorted array
        int x = 0;
        for (int i = 0; i < input.length; i = i + 2) {
            x = x * 10 + input[i];
        }
        
        //fill `y` with digits at the even indices of the sorted array
        int y = 0;
        for (int i = 1; i < input.length; i = i + 2) {
            y = y * 10 + input[i];
        }
        
        // print `x` and `y`
        System.out.println("The two numbers with maximum sum are "+x+ " and "+y);
    }
    
    /**
     * Distinct elements in every subarray of size `k`
     *
     * Given an array and an integer k, find the count of distinct elements in every subarray of size k.
     *
     * Input:
     *
     * arr[] = { 2, 1, 2, 3, 2, 1, 4, 5 };
     * k = 5;
     *
     * Output:
     *
     * The count of distinct elements in subarray { 2, 1, 2, 3, 2 } is 3
     * The count of distinct elements in subarray { 1, 2, 3, 2, 1 } is 3
     * The count of distinct elements in subarray { 2, 3, 2, 1, 4 } is 4
     * The count of distinct elements in subarray { 3, 2, 1, 4, 5 } is 5
     *
     * https://www.techiedelight.com/count-distinct-elements-every-sub-array-size-k-array/
     *
     * Targets arrays that are contiguous (occupy consecutive positions) and inherently maintains the order of elements
     */
    void findDistinctCount(List<Integer> input, int k) {
        // loop through the list
        for (int i = 0; i < input.size() - (k - 1); i++) {
            Set<Integer> distinct = new HashSet<>();
            distinct.addAll(input.subList(i, i + k));
            System.out.println("The count of distinct elements in "+" subarray ["+i+", "+(i + k - 1)+"] is "+distinct.size());
        }
    }
    
    /**
     * Find duplicates withing a range `k` in an array
     * Given an array and a positive number k, check whether the array contains any duplicate elements within the range k.
     * If k is more than the array's size, the solution should check for duplicates in the complete array
     *
     * Input:
     *
     * A[] = { 5, 6, 8, 2, 4, 6, 9 }
     * k = 4
     *
     * Output: Duplicates found
     *
     * (element 6 repeats at distance 4 which is <= k)
     *
     *
     * Input:
     *
     * A[] = { 5, 6, 8, 2, 4, 6, 9 }
     * k = 2
     *
     * Output: No duplicates were found
     *
     * (element 6 repeats at distance 4 which is > k)
     *
     *
     * Input:
     *
     * A[] = { 1, 2, 3, 2, 1 }
     * k = 7
     *
     * Output: Duplicates found
     *
     * (element 1 and 2 repeats at distance 4 and 2, respectively which are both <= k)
     *
     * The idea is to process every window of size k and store its elements in a set.
     * If any element repeats in the windowm we can say that it repeats within the range of k.
     *
     * Initially, our window will contain the first k elements of the input. Then for each item of the remaining input,
     * add it to the current window. While adding the i'th item of the input to the current window, remove the (i - k)'th element from it.
     * This ensures the efficienc of the solution and keeps the window balance at any point
     */
    boolean hasDuplicate(int[] arr, int k) {
        //Create an empty set to store the elements within the range `k`
        Set<Integer> window = new HashSet<>();
        
        //traverse the array
        for (int i = 0; i < arr.length; i++) {
            // if the current element already exists in the window, then it repeats within a range of `k`
            if (window.contains(arr[i]))
                return true;
            
            // add the current element to the window
            window.add(arr[i]);
            
            //remove the element at k'th range from the current element
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }
        //No element repeats withing range `k`
        return false;
    }
    
}
