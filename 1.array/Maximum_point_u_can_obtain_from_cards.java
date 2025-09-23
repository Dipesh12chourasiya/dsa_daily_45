public class Maximum_point_u_can_obtain_from_cards {
    
}


// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// https://www.youtube.com/watch?v=pBWCOCS636U

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Step 1: Take the first k cards from the left
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum; // current best score
        int rightSum = 0;     // sum of cards we take from the right
        int r = n - 1;        // right pointer (last index)

        // Step 2: Try moving from left to right gradually
        // Remove one card from leftSum and add one card from rightSum each time
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];   // remove one card from left
            rightSum += cardPoints[r];  // add one card from right
            r--;                        // move right pointer

            int currSum = leftSum + rightSum; // total score with this split
            maxSum = Math.max(currSum, maxSum); // update max
        }

        return maxSum;
    }
}

