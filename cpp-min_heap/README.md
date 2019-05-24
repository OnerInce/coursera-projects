# cpp-min_heap

**Problem Description**

The first step of the HeapSort algorithm is to create a heap from the array want to sort. Task is to implement this first step and convert a given array of integers into a heap. This will be done by applying a certain number of swaps to the array. Swap is an operation which exchanges two elements of the array. Need to convert the array into a heap using only O(n) swaps. Note that also need to use a min-heap instead of a max-heap in this problem.

**Input Format**

The first line of the input contains single integer n. The next line contains n space-separated integers.

**Output Format**

The first line of the output should contain single integer m — the total number of swaps. The next m lines should contain the swap operations used to convert the array into a heap. Each swap is described by a pair of integers i, j the 0-based indices of the elements to be swapped. After applying all the swaps in the specified order the array must become a heap.