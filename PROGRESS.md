# Re-learning progress

How to use this:
- Work topics top to bottom. Start with the ⭐ problems in each topic (the core patterns), then do others as time allows.
- Tick `[x]` only after you have solved it again **from scratch, with a test**, before looking at your old code.
- 🧪 = a test already exists in `unittest/` (you can use it to check your new solution).
- Difficulty is a guess: E = easy, M = medium, H = hard.
- Add any problem you struggled with to **Review queue** at the bottom.

---

## 1. Arrays

- [ ] ⭐ TwoSum — hash map of seen values — E 🧪
- [ ] ⭐ MaxSubArraySum — Kadane's algorithm — M 🧪
- [ ] ⭐ ProductExceptSelf — prefix and suffix products — M 🧪
- [ ] ⭐ LongestConsecutive — hash set, start only at sequence beginnings — M 🧪
- [ ] ⭐ SubArraySumEqualK — prefix sum + hash map of counts — M
- [ ] ⭐ MinSizesubArraySum — sliding window (variable size) — M
- [ ] ⭐ ThreeSum — sort + two pointers — M
- [ ] ⭐ MergeOverlappingIntervals — sort by start, merge — M
- [ ] TwoSumSorted — two pointers — E
- [ ] TripletSumZero — sort + two pointers — M
- [ ] PairWithGivenSum — hash set or two pointers — E
- [ ] CountPairsGivenSum — hash map of counts — E
- [ ] DivisibleSumPairs — remainder counting — E
- [ ] KDiffPairs — hash map — M
- [ ] ClosestPairofSortedArrays — two pointers across arrays — M
- [ ] SortedSquaredArr / SquareSortedArray — two pointers from both ends — E
- [ ] MergeSortedArray — two pointers from the back — E
- [ ] MergeArray — two pointers — E
- [ ] UnionAndIntersectionArrays — hash set or two pointers — E
- [ ] RemoveArrayDuplicates — read/write pointers — E
- [ ] ReverseArray — two pointers swap — E
- [ ] RotateArrKtimes — triple reverse — M
- [ ] ArrayLeftShift — rotation / modulo indexing — E
- [ ] OddEven / SeparateOddsAndEvens — partition with two pointers — E
- [ ] MaxProductSubArray — track running max and min — M
- [ ] ArrayMaxConsecutiveSum — fixed-size sliding window — E
- [ ] SmallestSubArrLen — sliding window — M
- [ ] SubArrSumLessThanK — sliding window — M
- [ ] ContinuousSubArraySum — prefix sum mod k + hash map — M
- [ ] CountRangeSum — prefix sums + merge sort — H
- [ ] SlidingWindowMax — monotonic deque — H
- [ ] LargestSubArrConseqIntegers — window with min/max + set — M
- [ ] MaxLenSubsequence — hash set — M
- [ ] MinLenUnsortedArr — find bounds by scanning both ways — M
- [ ] NextPermutation — find pivot, swap, reverse suffix — M
- [ ] LargestNumber — custom comparator on strings — M
- [ ] MissingNumber — sum formula or XOR — E
- [ ] MissingNumbers — counting — E
- [ ] MissingPositive — cyclic sort / index marking — H
- [ ] TheDuplicateNumber — Floyd's cycle detection — M
- [ ] FindAllDupsInArray — index marking with negation — M
- [ ] FirstInDuplicate — hash set — E
- [ ] DuplicateInRangeK — sliding hash set — E
- [ ] FirstNonRepeatingNum — count map, second pass — E
- [ ] FindDistinctCount — hash set — E
- [ ] LuckyNumber — frequency count — E
- [ ] MigratoryBirds — frequency count — E
- [ ] CountSmaller — merge sort with indices / BIT — H
- [ ] NumberSmallerThanCurrent / SmallerNumbersThanCurrent — counting sort / prefix counts — E
- [ ] SecondLargest / ThirdMaxNum / ThreeLargestNumbers / TopTwoMaximum — single pass tracking — E
- [ ] LargestAdjacentSum — single pass — E
- [ ] MaxArrElemDiff — track running min — E
- [ ] MinAbsDifference — sort, compare neighbours — E
- [ ] ShortestDistanceBtnNumbers / ShortestDistanceBtnNumbersInArray — track last indices — E
- [ ] DistanceBtnArrays — sort + binary search — E
- [ ] FairIndex — prefix sums — M
- [ ] HalfArraySum — prefix sums — E
- [ ] MinStartValue — prefix sum minimum — E
- [ ] ProductSum — recursion on nested lists — E
- [ ] PythagoreanTripples — sort + two pointers — M

## 2. Strings

- [ ] ⭐ ValidAnagram — character counts — E
- [ ] ⭐ LongestNonRepeatingCharStr — sliding window + last-seen map — M
- [ ] ⭐ FindAnagrams — fixed sliding window of counts — M
- [ ] ⭐ MinWindowString — sliding window with "need" counts — H
- [ ] ⭐ IsomorphicStrings — two-way char mapping — E
- [ ] Anagram / AnagramDelete / CheckPermutation — character counts — E
- [ ] LongestSubString — sliding window — M
- [ ] LongestSubStrKDistinctChars — sliding window + count map — M
- [ ] SmallestSubStringOfAllCharacters / SmallestSubstrOfAllChars — sliding window — H
- [ ] LongestRepetitiveChar — single pass run tracking — E
- [ ] LongestCommonPrefix — vertical scan — E
- [ ] FirstNonRepeatingChar / FirstUniqueCharacter — counts, second pass — E
- [ ] IsUnique — set or bit mask — E
- [ ] IsSequence — two pointers — E
- [ ] Palindrome — two pointers — E
- [ ] ShortestPalindrome — KMP prefix function — H
- [ ] ReverseString / StrReverse — two pointers — E
- [ ] ReverseWordInString — split and reverse, or reverse twice — M
- [ ] VowelReverse — two pointers — E
- [ ] ReverseInGroupsOfFour — chunked reverse — E
- [ ] StringRotation — `(s1 + s1).contains(s2)` — E
- [ ] StrRemoveAdjacentDups — stack — E
- [ ] RemoveKDigits — monotonic stack — M
- [ ] RemoveOccurences — stack / string builder — M
- [ ] MultiplyString — grade-school multiplication into array — M
- [ ] CountAndSay — iterative run-length — M
- [ ] RunLenEncoding — run-length — E
- [ ] SortCharacterByFrequency — counts + bucket sort / heap — M
- [ ] RearrangeChars — max heap, place most frequent first — M
- [ ] MinimumDeletionsToMakeCharFreqUnique — greedy on sorted frequencies — M
- [ ] SherlockandValidString — frequency of frequencies — M
- [ ] CountingDuplicates — counts — E
- [ ] SortStringChars — counting sort — E
- [ ] URLify — fill from the back — E
- [ ] CeaserCipher / RotationalCipher — modulo shifting — E
- [ ] MissingLetter — scan for gap — E
- [ ] ShortestWord / SimplePigLatin / UniqueLettersSet / ValidatePin / Diamond — string handling basics — E
- [ ] StringBasedAlgorithms — mixed practice — E

## 3. Searching

- [ ] ⭐ BinarySearch — classic lo/hi loop — E 🧪
- [ ] ⭐ FirstAndLastPosition — lower/upper bound binary search — M
- [ ] ⭐ SearchRotatedArr — binary search, decide which half is sorted — M
- [ ] ⭐ Painter — binary search on the answer — H
- [ ] MinElemInRotatedArr / MaxElemRotatedArr / ArrayRotation — binary search for the pivot — M
- [ ] ClosestNumber — binary search — E
- [ ] KClosestElements — binary search for window start — M
- [ ] KthElementTwoSortedArr — binary search partition — H
- [ ] KthSmallestElem — quickselect or heap — M
- [ ] MajorityElement — Boyer–Moore voting — E
- [ ] RepeatingElement — binary search / indexing — M

## 4. Sorting

- [ ] ⭐ SortArray — merge sort / quick sort — M
- [ ] ⭐ SortArr012 — Dutch national flag (three pointers) — M
- [ ] BubbleSort / InsertionSort / SelectionSort — basic sorts — E
- [ ] SortAlmostSortedArray — min heap of size k+1 — M
- [ ] SortArrByIncreasingFrequency — counts + custom comparator — E

## 5. Linked lists

- [ ] ⭐ ReverseLinkedList — iterative prev/curr/next — E
- [ ] ⭐ LinkedListMiddleElement — slow/fast pointers — E
- [ ] ⭐ RemoveNthNodeFromEndOfList — two pointers n apart, dummy head — M
- [ ] ⭐ PalindromeLinkedList — find middle, reverse second half — M
- [ ] AddTwoNumbers — digit-by-digit with carry — M
- [ ] LinkedListKthLastNode — two pointers k apart — E
- [ ] LinkedListLastElemToFirst — pointer manipulation — E
- [ ] ImplementLinkedList / TailLinkedList — build it yourself — E
- [ ] LinkedLists — mixed practice — M

## 6. Stacks & queues

- [ ] ⭐ BalancedBrackets — stack of open brackets — E
- [ ] ⭐ MinStack — stack of (value, current min) — M
- [ ] ⭐ StackUsingTwoQueues — rotate on push — E 🧪
- [ ] ImplementQueue — queue with two stacks — E
- [ ] ReverseKElemInQueue — stack for first k — E 🧪
- [ ] ReverseQueue / ReverseStackRecursively — recursion — M
- [ ] MinBracketReversal — stack, cancel matched pairs — M
- [ ] Parentheticals / JavaStackBalancedBrackets — stack — E
- [ ] ArrayQueue / LinkedListQueue / QueueLinkedList / StackLinkedList — build it yourself — E

## 7. Heaps

- [ ] ⭐ KthLargestElementInArray — min heap of size k — M
- [ ] ⭐ TopKFreqElements — counts + heap or bucket sort — M
- [ ] ⭐ KClosestPointToOrigin — max heap of size k — M
- [ ] Heap — implement sift-up / sift-down — M
- [ ] KLargestElem / TopKElementsInArray — heap of size k — E
- [ ] TopKFrequentWords — heap with tie-break comparator — M
- [ ] SlowSum — greedy with min heap — M
- [ ] JPriorityQueue / PriorityQ — Java PriorityQueue + comparators — E

## 8. Trees

- [ ] ⭐ TreeTraversal — pre/in/post order, recursive and iterative; level order with queue — E
- [ ] ⭐ MaxDepthBinaryTree — recursion (DFS) — E
- [ ] ⭐ ValidateBST — pass min/max bounds down — M
- [ ] ⭐ BinaryTreeDiameter — height recursion, track best — E 🧪
- [ ] ⭐ RightViewBinaryTree — BFS by level, last node — M
- [ ] InvertBinaryTree — swap children recursively — E
- [ ] BalancedBinaryTree / GfGBalancedBinaryTree — height with early -1 — E
- [ ] LeftViewBinaryTree — BFS by level, first node — E
- [ ] BinaryTreeVisibleNodes — DFS carrying max so far — M
- [ ] SpiralOrderBinaryTree — BFS alternating direction / two stacks — M
- [ ] ReverseLevelOrderBinaryTree — BFS + stack — E
- [ ] PrintPerfectBinaryTree — BFS — M
- [ ] SecondMinNodeInBinaryTree — DFS — E
- [ ] TreeFindMode — inorder traversal of BST, count runs — E
- [ ] KthSmallestElementBST / KthLargestElementInBST — (reverse) inorder with counter — M
- [ ] MinAbsDiffBST — inorder, compare neighbours — E
- [ ] TwoSumBST — inorder + two pointers, or hash set — E
- [ ] BSTClosestVal — walk down the BST — E
- [ ] BSTSuccessorSearch — walk down / right subtree min — M
- [ ] BST / BSTConstruction / ImplementBST / BinaryTree — insert, search, delete — M
- [ ] BstPriceRange — BST range query — M

## 9. Graphs

- [ ] ⭐ BFS — queue + visited — E
- [ ] ⭐ DFSImplementation — recursion / stack + visited — E
- [ ] ⭐ NumIslands — flood fill on a grid — M
- [ ] ⭐ DijkstraAlgorithm — min heap of distances — M
- [ ] AdjacencyListExample / Graph — building a graph — E
- [ ] GraphValidPath — BFS/DFS or union-find — E 🧪
- [ ] NumOfOffices — grid flood fill — M
- [ ] NetworkDelayTime — Dijkstra — M
- [ ] CheapestFlight / CheapestFlightsWithKStops — Bellman-Ford or BFS with stops — M
- [ ] BusRoutes — BFS over routes — H
- [ ] ShortestPathVisitingAllNodes — BFS over (node, bitmask) states — H
- [ ] GraphPriceRange — graph traversal with filtering — M

## 10. Backtracking

- [ ] ⭐ Subsets — include / exclude each element — M 🧪
- [ ] ⭐ Permutations — swap or used[] array — M 🧪
- [ ] ⭐ CombinationSum — choose, recurse, un-choose; reuse allowed — M
- [ ] ⭐ WordSearch — DFS on grid, mark and unmark — M
- [ ] StringPermutations — permutations of characters — M 🧪
- [ ] LetterCombinations — one digit per level — M
- [ ] ConcatenatedStrUniqueChars — backtracking with bit masks — M
- [ ] MaxSubsequenceChars — backtracking — M
- [ ] BacktrackingCls (N-Queens) — place row by row, check columns/diagonals — H
- [ ] Sudoku — try 1–9, check constraints — H
- [ ] TowerOfHanoi — recursion — E

## 11. Dynamic programming

- [ ] ⭐ ClimbingStairs — dp[i] = dp[i-1] + dp[i-2] — E
- [ ] ⭐ MinNumberofCoins — unbounded knapsack (min) — M
- [ ] ⭐ LongestIncreasingSubsequence — O(n²) DP, then patience sort O(n log n) — M
- [ ] ⭐ PartitionEqualSubSetSum — 0/1 knapsack on sum/2 — M
- [ ] Fibonacci — recursion → memo → bottom-up — E 🧪
- [ ] NthStairCase / StairCaseTraversal / StaircaseProblem / MouseJumpWays — staircase variants — E
- [ ] SubsetSum / PerfectSum — 0/1 knapsack (exists / count) — M
- [ ] TargetSum — reduce to subset sum count — M
- [ ] MaxSumSubsequence — house robber style — M
- [ ] MaxLenOfRepeatedSubArray — 2D DP on two arrays — M
- [ ] LargestDivisibleSubsets — sort + LIS-style DP — M

## 12. Greedy

- [ ] ⭐ GreedyAlgorithm (fractional knapsack) — sort by value/weight — M
- [ ] MaxArrSumKNegations — flip smallest values — E
- [ ] ATM — greedy change-making — E

## 13. Matrix

- [ ] ⭐ RotateImage — transpose + reverse rows — M
- [ ] ⭐ SearchSortedMatrix — start top-right corner — M
- [ ] SearchMatrix — treat as 1D sorted array, binary search — M
- [ ] RotateArrayMatrix — layer-by-layer rotation — M
- [ ] PeakElemIn2DArr — binary search on columns — H
- [ ] ToeplitzMatrix — compare with top-left neighbour — E
- [ ] HourGlass / Sum2DArray / Matrix — 2D indexing — E

## 14. Math

- [ ] ⭐ GCD / LCM — Euclid's algorithm — E 🧪
- [ ] ⭐ CountPrimes — Sieve of Eratosthenes — M
- [ ] ⭐ SquareRoot — binary search on answer — E
- [ ] PrimeNumber / PrimeNumberCounter — trial division to √n — E
- [ ] HappyNumber — cycle detection (set or slow/fast) — E
- [ ] PowerOfTwo / PowerOfThree — bit trick / division — E
- [ ] ReverseInteger — digit pop/push with overflow check — M
- [ ] SqrtPrecision — binary search + decimal steps — M
- [ ] FindNextPerfectSquare / TriangularNum / NthTermOfSeries / Product1toN — formulas — E

## 15. Design

- [ ] ⭐ MyCalendar — TreeMap floor/ceiling for overlap — M 🧪
- [ ] ImplementIterator — iterator over nested structure — M
- [ ] FileSystem — trie of paths — M
- [ ] FactoryMethod — design pattern (Shape factory) — E

## 16. Mixed review (do last, timed like an interview)

- [ ] AmazonTopKFreqWords
- [ ] MSCodilityFeb172021
- [ ] MSInterviewPrep
- [ ] SafCom
- [ ] Toptal
- [ ] DemoSolution

---

## Review queue

Problems that took a while. Solve again after 3 days, then after 2 weeks.

| Problem | First redo | +3 days | +2 weeks |
|---------|------------|---------|----------|
|         |            |         |          |
