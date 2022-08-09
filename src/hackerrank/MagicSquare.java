package hackerrank;

import java.util.Arrays;

public class MagicSquare {
    public static void main(String[] args) {
        // Start with 1 known solution
        int[] m0 = {
            2, 9, 4,
            7, 5, 3,
            6, 1, 8
        };
        
        // Rotate the above solution clockwise
        int[] m4 = {
            6, 7, 2,
            1, 5, 9,
            8, 3, 4
        };

        int[][] solutions = new int[8][9];
        // Reflect the above two solutions along y and x axis to obtain all 8 solutions
        int[] m1 = reflectY(m0);
        int[] m2 = reflectX(m1);
        int[] m3 = reflectY(m2);
        int[] m5 = reflectY(m4);
        int[] m6 = reflectX(m5);
        int[] m7 = reflectY(m6);
        solutions[0] = m0;
        solutions[1] = m1;
        solutions[2] = m2;
        solutions[3] = m3;
        solutions[4] = m4;
        solutions[5] = m5;
        solutions[6] = m6;
        solutions[7] = m7;
        System.out.println(Arrays.deepToString(solutions));

        int[] input = {
            4, 9, 2,
            3, 5, 7,
            8, 1, 5
        };

        int minCost = Integer.MAX_VALUE;
        for (int[] m : solutions) {
            int cost = 0;
            for (int i = 0; i < m.length; i++) {
                cost += Math.abs(m[i] - input[i]);
            }
            minCost = Math.min(minCost, cost);
        }

        System.out.println(minCost);
    }

    private static int[] reflectY(int[] m) {
        int[] c_m = Arrays.copyOf(m, m.length);
        swapij(c_m, 0, 2); // swap 0, 2
        swapij(c_m, 3, 5); // swap 3, 5
        swapij(c_m, 6, 8); // swap 6, 8
        return c_m;
    }

    private static int[] reflectX(int[] m) {
        int[] c_m = Arrays.copyOf(m, m.length);
        swapij(c_m, 0, 6); // swap 0, 6
        swapij(c_m, 1, 7); // swap 1, 7
        swapij(c_m, 2, 8); // swap 2, 8
        return c_m;
    }

    private static void swapij(int[] m, int i, int j) {
        int t = m[i];
        m[i] = m[j];
        m[j] = t;
    }

}
