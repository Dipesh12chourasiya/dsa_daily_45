// // Approach-1 (Simple Recursion)
// //T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
// //S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         generate("", n, 0, result);
//         return result;
//     }

//     // Function to check if the parentheses are valid
//     private boolean isValid(String str) {
//         int sum = 0;
//         for (char ch : str.toCharArray()) {
//             if (ch == '(')
//                 sum++;
//             else
//                 sum--;
//             if (sum < 0)
//                 return false;
//         }
//         return sum == 0;
//     }

//     // Recursive function to generate parentheses
//     private void generate(String curr, int n, int length, List<String> result) {
//         if (length == 2 * n) {
//             if (isValid(curr))
//                 result.add(curr);
//             return;
//         }

//         curr += '(';
//         generate(curr, n, length + 1, result);

//         curr = curr.substring(0, curr.length() - 1); // remove the last character

//         curr += ')';
//         generate(curr, n, length + 1, result);
//     }
// }


// https://leetcode.com/problems/generate-parentheses/description/
// Approach-2 (Smart Recursion)
//T.C : O(2^n)
//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree

import java.util.*;

public class GenerateParanthesys {
    // List to store all valid combinations
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // Start recursive backtracking with empty string, 0 open and 0 close brackets
        solve(n, "", 0, 0);
        return result;
    }

    // Recursive function to generate all valid parentheses
    private void solve(int n, String curr, int open, int close) {
        // Base case: if the current string has length 2*n, it's a valid combination
        if (curr.length() == 2 * n) {
            result.add(curr); // add to the result list
            return;
        }

        // Option 1: Add an opening bracket '(' if we still have some left
        if (open < n) {
            curr += '('; // add '('
            solve(n, curr, open + 1, close); // recurse with one more open bracket
            curr = curr.substring(0, curr.length() - 1); // backtrack (remove last '(')
        }

        // Option 2: Add a closing bracket ')' if it won't break validity
        if (close < open) { 
            curr += ')'; // add ')'
            solve(n, curr, open, close + 1); // recurse with one more close bracket
            // No need to backtrack here since 'curr' is discarded after recursion
        }
    }
}


// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 