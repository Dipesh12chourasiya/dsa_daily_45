import java.util.*;

public class Find_all_duplicate_in_array {
    
}


// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         Set<Integer> set = new HashSet<>();

//         for(int i=0; i<nums.length; i++){
//             if(set.contains(nums[i])){
//                 ans.add(nums[i]);
//             }
//             set.add(nums[i]);
//         }
//         return ans;
//     }
// }

// https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Result list to store duplicate numbers
        List<Integer> result = new ArrayList<>();
        
        // Traverse through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Take the absolute value because some numbers
            // might have been marked negative already
            int val = Math.abs(nums[i]);

            // If the number at index (val-1) is already negative,
            // it means we've seen this number before => it's a duplicate
            if (nums[val - 1] < 0) {
                result.add(val);
            } else {
                // Otherwise, mark the number as "seen"
                // by flipping its corresponding index to negative
                nums[val - 1] *= -1;
            }
        }

        // Return all duplicates collected
        return result;
    }
}

// Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]'