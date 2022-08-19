package DP;

import java.util.Arrays;

public class MatrixTravel {
    static int[][] matrix = {
        { 4, 6, 14, 21 },
        { 17, 0, 5, 5 },
        { 4, 41, 22, 3 },
        { 2, 51, 6, 0 },
    };

    static final int ENERGY = 100;

    public static void main(String[] args) {
        int energyLeft = travelGrid(matrix);
        System.out.println( energyLeft );
    }

    private static int travelGrid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] tMat = new int[cols];
        int[] cMat = new int[cols];
        
        // First Row is mandatory travel
        System.arraycopy(matrix[0], 0, cMat, 0, cols);
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j - 1 < 0) {
                    tMat[j] = matrix[i][j] + findMin(cMat[j], cMat[j + 1]);
                } else if (j + 1 > cols - 1) {
                    tMat[j] = matrix[i][j] + findMin(cMat[j - 1], cMat[j]);
                } else {
                    tMat[j] = matrix[i][j] + findMin(cMat[j - 1], cMat[j], cMat[j + 1]);
                }
            }
            System.arraycopy(tMat, 0, cMat, 0, cols);
            System.out.println(Arrays.toString(cMat));
        }
        return ENERGY - findMin(cMat);
    }

    private static int findMin(int ...nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(n, min);
        }
        return min;
    }
}
