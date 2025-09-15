public class ReverseWordsInString {
    
}


// https://leetcode.com/problems/reverse-words-in-a-string/

// class Solution {
//     public String reverseWords(String s) {

//         StringBuilder sb = new StringBuilder();
//         String words[] = s.split(" +");
//         int n = words.length;

//         for(int i=n-1; i>=0; i--){
//             sb.append(words[i]);
//             sb.append(" ");
//         }

//         String res = sb.toString().trim();

//         return res;
//     }
// }

class Solution {
    public String reverseWords(String s) {
        
        String words[] = s.split(" +");

        int i=0;
        int j = words.length - 1;

        while(i < j){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", words).trim();
    }
}