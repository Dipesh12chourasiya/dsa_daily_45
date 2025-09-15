// https://www.youtube.com/watch?v=TNe3gF4r128&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=11
// https://leetcode.com/problems/group-anagrams/description/
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char[] temp = strs[i].toCharArray();
            
            Arrays.sort(temp);
            String key = new String(temp);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }
}

