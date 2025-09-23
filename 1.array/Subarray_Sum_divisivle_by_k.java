import java.util.*;

public class Subarray_Sum_divisivle_by_k {
    
}


// https://leetcode.com/problems/subarray-sums-divisible-by-k/
// remender baba ki jat ho
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        
        mp.put(0, 1);
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            int rem = sum % k;
            
            if (rem < 0) {
                rem += k;
            }
            
            if (mp.containsKey(rem)) {
                result += mp.get(rem);
            }
            
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }
        
        return result;
    }
}


// Brute Force
// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int cn = 0;

//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[j];
//                 if(sum % k == 0) cn++;
//             }
//         }

//         return cn;
//     }
// }


// https://www.youtube.com/watch?v=7Xeorb721LQ&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=34