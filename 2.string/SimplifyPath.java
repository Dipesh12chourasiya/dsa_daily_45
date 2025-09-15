import java.util.Stack;

public class SimplifyPath {
    
}

// https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        String words[] = path.split("/");
        Stack<String> st = new Stack<>();

        for(String word: words){
            
            if(word.isEmpty() || word.equals(".")){
                continue;
            } else if(word.equals("..") && !st.isEmpty()){
                st.pop();
            } else if( !word.equals("..")){ //we have to do it to avoide  blindly push anything into the stack even if the word is ".." — when the stack is already empty.
                st.push(word);
            }
        }

        String res = "";

        if(st.isEmpty()) return "/";

        while(!st.isEmpty()){
            res = "/" + st.pop() + res;
        }
        return res;
    }
}