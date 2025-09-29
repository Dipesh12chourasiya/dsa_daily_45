
import java.util.*;


public class SubArraySUmEqualsK {
    
}

// https://leetcode.com/problems/subarray-sum-equals-k/

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int cn = 0;

//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[j];

//                 if(sum == k){
//                     cn++;
//                 }
//             }
//         }

//         return cn;
//     }
// }



// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int cn = 0;

//         int left = 0;
//         int sum = 0;

//         // sliding window will not work for : 

// //         given arr=[1,2,-3,1,2,-3] , k = 0  , output should be 3
// //         here A - [1,2,-3]& B - [1,2,-3] are SubArray with sum = 0.
// //         Now Sliding Window will take into the account A & B parts separately.
// //         But one of the solutions would be of whole Array as well A + B which 
//         //    Sliding Window technique misses.

//         for(int i=0; i<n; i++){ // i = right
//             sum += nums[i];

//             while(sum > k) {
//                 sum -= nums[left++];
//             }

//             if(sum == k){
//                 cn++;
//             }
//         }

//         return cn;
//     }
// }



//T.C : O(n)
//S.C : O(n)
 class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
            // sum , freq of sum
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                result += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}