/******************************************************************
 *
 *   Larry Gao / COMP 400C 002 SP25
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // create HashSet to store elements of array
        Set<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }
        
        // check if every element in k exists in set
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        
        return true;
    } // end method isSubset


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        // create min-heap to store top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add elements to the heap, keeping only k elements at a time
        for (int num : array) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest element to maintain size k
            }
        }

        // root of heap is k-th largest element
        return minHeap.peek();
    } // end method findKthLargest


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // create new array to hold all elements from array1 and array2
        int[] merged = new int[array1.length + array2.length];

        // copy elements from array1 into merged
        for (int i = 0; i < array1.length; i++) {
            merged[i] = array1[i];
        }

        // copy elements from array2 into merged
        for (int i = 0; i < array2.length; i++) {
            merged[array1.length + i] = array2[i];
        }

        // sort merged
        Arrays.sort(merged);

        return merged;
    } // end method sort2Arrays

} // end class ProblemSolutions
