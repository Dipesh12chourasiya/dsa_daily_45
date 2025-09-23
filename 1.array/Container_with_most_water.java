public class Container_with_most_water {
    
}


// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int l =0;
        int r = height.length-1;
        int maxWaterInCon = 0;
        
        while(l<r){
            int lh = height[l];
            int rh = height[r];
            int minH = Math.min(lh , rh);

            maxWaterInCon = Math.max(maxWaterInCon , minH * (r - l));

            if(lh < rh){
                l++;
            } else{
                r--;
            }
        }
        return maxWaterInCon;
    }
}