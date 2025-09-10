// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/





// class Solution {
//     public int strStr(String haystack, String needle) {
                
//         int m = haystack.length();
//         int n = needle.length();
        
//         for(int i=0; i<=m-n; i++){
//             for(int j=0; j<n; j++){
//                 if(haystack.charAt(i+j) != needle.charAt(j)){
//                     break;
//                 }
//                 if(j == needle.length()-1) return i;
//             }
//         }

//         return -1;
//     }
// }

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();  // Length of the main string
        int m = needle.length();    // Length of the substring to find

        // If needle is empty, return 0 (by definition of the problem)
        if (m == 0) return 0;

        // Loop through haystack, but only up to n - m (remaining part must fit needle)
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Check if needle matches starting from index i in haystack
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++; // Move to next character in needle
            }

            // If we matched all characters of needle, return starting index
            if (j == m) return i;
        }

        // If needle not found, return -1
        return -1;
    }
}
