import java.util.*;
public class Combinations {
    
}


class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();

        solve(1, n , k , temp);
        return res;
    }
    
    void solve(int start ,int n, int k, List<Integer> temp){

        if(k==0){
            res.add(new ArrayList<>(temp)); // Create a new ArrayList to store the current combination
            return;
        }

        if(start > n) return;

        // Include current element
        temp.add(start);
        solve(start+1, n, k-1, temp);
        temp.remove(temp.size() - 1); // Backtrack by removing the last element

        // Exclude current element
        solve(start+1, n, k, temp);
    }
}

// https://leetcode.com/problems/combinations/
// https://www.youtube.com/watch?v=QQ9Tn2i269I