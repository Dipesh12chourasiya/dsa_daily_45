
// https://leetcode.com/problems/find-the-duplicate-number/description/


//  Brute Force: giving time limit exceeded

// class Solution {
//     public int findDuplicate(int[] nums) {
        
//         int n = nums.length;

//         for(int i=0; i<n; i++){
//             int elem = nums[i];

//             for(int j=i+1; j<n; j++){
//                 if(nums[j] == elem){
//                     return elem;
//                 }
//             }
//         }

//         return -1;
//     }
// }


// by using slow and fast pointer technique
//T.C : O(n) Using "Hare & tortoise technique"
//S.C : O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast); // break means cycle hai

        slow = nums[0]; // cycle jaha start hui wo duplicate hai 
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}


// https://www.youtube.com/watch?v=49HrEGt6D2s&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=58
