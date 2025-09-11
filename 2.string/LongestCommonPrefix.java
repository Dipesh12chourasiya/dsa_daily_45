// https://leetcode.com/problems/longest-common-prefix/description/

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        Arrays.sort(strs);

        String ans = "";

        String fw = strs[0];
        String lw = strs[n-1];

        int i=0;

        while(i<fw.length() && i<lw.length()){
            if(fw.charAt(i) == lw.charAt(i)){
                ans += fw.charAt(i);
            }else{
                break;
            }
            i++;
        }

        return ans;
    }
}