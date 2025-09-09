// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0; // denotes for 0
        int j=0; // denotes for 1
        int k=n-1; // denotes for 2

        while( j<=k ){
            if(nums[j] == 0){
                swap(nums,j,i);
                i++;
                j++; // j++ because they have both started from 0 index
            } else if(nums[j] == 2){
                swap(nums, j, k);
                k--;
            } else if( nums[j] == 1){
                j++;
            }
        }
    }

    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

// https://www.youtube.com/watch?v=KDiZ3jGXxO8&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=15