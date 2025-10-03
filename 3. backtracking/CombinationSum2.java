import java.util.*;
public class CombinationSum2 {
    
}



//T.C : O(2^n)
//S.C : O(n)
class Solution {

    List<List<Integer>> result;
    public void solve(int[] candidates, int target, List<Integer> temp, int idx) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue; // Ignore duplicate elements
            }
            temp.add(candidates[i]);
            solve(candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates); // Sort to handle duplicates

        solve(candidates, target, temp, 0);
        return result;
    }
}


// https://www.youtube.com/watch?v=bfKwLi6jtDk
// https://leetcode.com/problems/combination-sum-ii/