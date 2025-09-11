
// https://leetcode.com/problems/integer-to-roman/

class Solution {
    public String intToRoman(int num) {
        // Values of Roman numerals in descending order
        int val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        // Corresponding Roman numeral symbols
        String sym[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String res = "";  // result string to store Roman numeral

        // loop through all values
        for (int i = 0; i < 13; i++) {
            if (num == 0) break;  // stop if number becomes 0

            // find how many times current value fits into num
            int times = num / val[i]; 

            // append the symbol 'times' number of times
            while (times > 0) {
                res += sym[i];  // add the Roman numeral
                times--;        // decrease the count
            }

            // reduce num by removing the already used part
            num = num % val[i];
        }

        return res; // return final Roman numeral
    }
}

// Example 2:

// Input: num = 58

// Output: "LVIII"

// Explanation:

// 50 = L
//  8 = VIII