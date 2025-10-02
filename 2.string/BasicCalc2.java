import java.util.Stack;


public class BasicCalc2 {
    
}

// https://www.youtube.com/watch?v=b_vCkD-rhiU
// https://leetcode.com/problems/basic-calculator-ii/

class Solution {
    public int calculate(String s) {

        int n = s.length();
        Stack<Integer> nmst = new Stack<>();
        int num = 0;
        char optr = '+';

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = (num*10) + ch - '0';
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                
                if(optr == '+'){
                    nmst.push(num);
                }
                else if(optr == '-'){
                    nmst.push(-1*num);
                }
                else if(optr == '*'){
                    nmst.push(num*nmst.pop());
                }
                else if(optr == '/'){
                    nmst.push(nmst.pop()/ num);
                }

                num = 0;
                optr = ch;
            }
        }

        int sum = 0;

        while(!nmst.isEmpty()){
            sum += nmst.pop();
        }


        return sum;
    }
}