import java.util.*;

public class Sum_3 {
    
}


//T.C : O(n^2)
//S.C : O(1)
// https://www.youtube.com/watch?v=_cBWWebTVpI&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=3
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            twoSum(nums, i + 1, result, target);
        }

        return result;
    }

    private void twoSum(int[] nums, int k, List<List<Integer>> result, int target) {
        int i = k, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;
            }
        }
    }
}