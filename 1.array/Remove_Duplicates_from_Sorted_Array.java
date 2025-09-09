// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// LeetCode 26: Remove Duplicates from Sorted Array
// Problem: Given a sorted array, remove duplicates in-place such that each element appears only once
// and return the new length. The relative order of the elements should be kept the same.

// Approach: Two Pointer Method
// - Since the array is sorted, duplicates will always be next to each other.
// - Use one pointer (idx) to keep track of the position of the next unique element.
// - Traverse the array, and when a new unique element is found, place it at nums[idx].
// - At the end, idx will represent the count of unique elements.

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        // If array has only one element, it’s already unique
        if (n == 0) return 0;
        
        // idx points to the next position where unique element should be placed
        int idx = 1; 
        
        // Traverse from the 2nd element to the end
        for (int i = 1; i < n; i++) {
            
            // If current element is different from the previous one,
            // it is unique → place it at nums[idx] and increment idx
            if (nums[i - 1] != nums[i]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        // idx is the length of the array with unique elements
        return idx;
    }
}
