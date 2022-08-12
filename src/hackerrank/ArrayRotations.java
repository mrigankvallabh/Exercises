package hackerrank;

import java.util.Arrays;

public class ArrayRotations {
    public static void main(String[] args) {
        int[] arr = { 6, 7, 4, 5, 0, 2, 9 };

        int[] al = rotateArrLeft(arr, 3);
        int[] ar = rotateArrRight(arr, 3);

        System.out.println(Arrays.toString(al));
        System.out.println(Arrays.toString(ar));
    }

    /**
     * Rotate Array arr Left by k units. For e.g.
     * 
     * <pre>
     * i =  0, 1, 2, 3, 4, 5, 6
     * </pre>
     * <hr />
     * 
     * <pre>
     * a = {6, 7, 4, 5, 0, 2, 9}
     * </pre>
     * 
     * <pre>
     * r = {5, 0, 2, 9, 6, 7, 4}
     * </pre>
     * 
     * after k = 3 rotations to left
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int[] rotateArrLeft(int[] arr, int k) {
        int length = arr.length;
        int[] t = new int[length];
        for (int i = 0; i < length; i++) {
            t[i] = arr[(i + k) % length];
        }
        return t;
    }

    /**
     * Rotate Array arr Left by k units. For e.g.
     * 
     * <pre>
     * i =  0, 1, 2, 3, 4, 5, 6
     * </pre>
     * <hr />
     * 
     * <pre>
     * a = {6, 7, 4, 5, 0, 2, 9}
     * </pre>
     * 
     * <pre>
     * r = {0, 2, 9, 6, 7, 4, 5}
     * </pre>
     * 
     * after k = 3 rotations to right
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int[] rotateArrRight(int[] arr, int k) {
        int length = arr.length;
        int[] t = new int[length];
        for (int i = 0; i < length; i++) {
            t[i] = arr[(((i - k) % length) + length) % length];
        }
        return t;
    }

}
