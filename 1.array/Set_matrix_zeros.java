// https://leetcode.com/problems/set-matrix-zeroes/

// LeetCode 73: Set Matrix Zeroes
// Approach: Find positions of zeros, then set entire row & column to zero

import java.util.*;

class Solution {
    int n, m;
    
    public void setZeroes(int[][] matrix) {
        
        n = matrix.length;
        m = matrix[0].length;
        
        // Store coordinates of all zero elements
        Set<int[]> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
            }
        }

        // For each zero, set entire row and column to zero
        for (int[] v : set) {
            int i = v[0];
            int j = v[1];

            setZeroUp(i, j, matrix);
            setZeroDown(i, j, matrix);
            setZeroLeft(i, j, matrix);
            setZeroRight(i, j, matrix);
        }
    }

    // Set column upwards to zero
    void setZeroUp(int x, int c, int[][] matrix) {
        for (int i = x; i >= 0; i--) {
            matrix[i][c] = 0;
        }
    }
    
    // Set column downwards to zero
    void setZeroDown(int x, int c, int[][] matrix) {
        for (int i = x; i < n; i++) {
            matrix[i][c] = 0;
        }
    }

    // Set row leftwards to zero
    void setZeroLeft(int x, int c, int[][] matrix) {
        for (int j = c; j >= 0; j--) {
            matrix[x][j] = 0;
        }
    }

    // Set row rightwards to zero
    void setZeroRight(int x, int c, int[][] matrix) {
        for (int j = c; j < m; j++) {
            matrix[x][j] = 0;
        }
    }
}
