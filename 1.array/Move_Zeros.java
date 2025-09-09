// https://leetcode.com/problems/move-zeroes/description/


// LeetCode 283: Move Zeroes
// Approach: Shift non-zeros forward, then fill remaining with zeros

class Solution {
    public void moveZeroes(int[] nums) {
        
        int idx = 0;          // position to place next non-zero
        int n = nums.length;

        // Move all non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        // Fill remaining positions with zeros
        while (idx < n) {
            nums[idx++] = 0;
        }
    }
}
