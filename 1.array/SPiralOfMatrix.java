// public class SPiralOfMatrix {
    
// }

import java.util.*;


// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top   = 0;
        int down  = m-1;
        int left  = 0;
        int right = n-1;

        int dir = 0;
        // dir =0 then print top row
        // dir = 1 then print right colmn
        // dir = 2 then print down row
        // dir = 3 then print left col

        List<Integer> ans= new ArrayList<>();

        while(top <= down && left <= right){
            if(dir == 0){
                // left to right
                for(int i=left; i<=right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                // top to down
                for(int i=top; i<=down; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            } 
            else if(dir == 2){
                //right to left
                for(int i= right; i>=left; i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            else if(dir == 3){
                //down to top
                for(int i=down; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
            // System.out.println(dir);
        }
        return ans;
    }
}

// https://www.youtube.com/watch?v=73j2ipxR958&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=10