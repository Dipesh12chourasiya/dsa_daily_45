// https://www.youtube.com/watch?v=wX3-411uJH0
// https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public boolean validPalindrome(String s) {
        
        int l = 0;                  // left pointer
        int r = s.length() - 1;     // right pointer

        // loop until left < right
        while(l < r){
            // if characters match, move both pointers inward
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                // if mismatch occurs, try skipping one character 
                // either from left (l+1) or from right (r-1)
                return isPalim(s, l+1, r) || isPalim(s, l, r-1);
            }
        }

        return true; // if loop finishes, string is already palindrome
    }

    // helper function to check if substring s[l...r] is a palindrome
    boolean isPalim(String s, int l, int r){

        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return false; // mismatch found → not a palindrome
            }
        }

        return true; // no mismatches → it is a palindrome
    }
}
