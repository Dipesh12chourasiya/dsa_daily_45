import java.util.Stack;

public class BasicCalculator {
    
}




// https://leetcode.com/problems/basic-calculator/
// https://www.youtube.com/watch?v=3AEKyHx3tzU&t=1632s

class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int num = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = (num * 10) + ch - '0';
            } else if (ch == '+') {
                res += num * sign;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                res += num * sign;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;

            } else if (ch == ')') {
                res += sign * num;
                num = 0;
                int signFromStack = st.pop(); // sign

                res *= signFromStack;

                int resultFromStack = st.pop(); // previous result
                res += resultFromStack;
            }
        }

        res += num * sign;

        return res;
    }
}