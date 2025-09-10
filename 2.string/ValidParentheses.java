import java.util.Stack;


// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();
        int n = s.length();

        // Loop through each character in the string
        for (int i = 0; i < n; i++) {

            // If the current character is an opening bracket, push it onto the stack
            if (isOpen(s.charAt(i))) {
                st.push(s.charAt(i));
            } 
            // If it's a closing bracket but the stack is empty, it's invalid
            else if (isClose(s.charAt(i)) && st.isEmpty()) {
                return false;
            }
            // If it's a closing bracket and stack is not empty
            else if (isClose(s.charAt(i)) && !st.isEmpty()) {

                // Check if the top of the stack matches the current closing bracket
                if ((st.peek() == '(' && s.charAt(i) != ')')
                        || (st.peek() == '[' && s.charAt(i) != ']')
                        || (st.peek() == '{' && s.charAt(i) != '}')) {
                    // If it doesn't match, the string is invalid
                    return false;
                } else {
                    // If it matches, pop the opening bracket
                    st.pop();
                }
            }
        }

        // At the end, if the stack is empty, it's valid; otherwise, it's invalid
        return st.isEmpty();
    }

    // Helper method to check if the character is an opening bracket
    boolean isOpen(char c) {
        return (c == '(') || (c == '[') || (c == '{');
    }

    // Helper method to check if the character is a closing bracket
    boolean isClose(char c) {
        return (c == ')') || (c == ']') || (c == '}');
    }
}
