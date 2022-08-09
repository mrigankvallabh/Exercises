package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickingNumbers {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(new Integer[] {4, 6, 5, 3, 3, 1});
        int mxz = pickingNumbersMap(intList);
        System.out.println(mxz);
    }

    public static int pickingNumbers(List<Integer> a) {
        int maxSize = Integer.MIN_VALUE;
        for (Integer k : a) {
            List<Integer> s2 = new ArrayList<>();
            List<Integer> s1 = new ArrayList<>();
            for (Integer p : a) {
                if (k - p == 1 || k - p == 0) {
                    s1.add(p);
                }
                if (k - p == -1 || k - p == 0) {
                    s2.add(p);
                }
            }
            maxSize = Math.max(maxSize, Math.max(s1.size(), s2.size()));
        }
        return maxSize;
    }

    public static int pickingNumbersMap(List<Integer> a) {
        int maxSize = Integer.MIN_VALUE;
        /*
         * if the array is {4, 6, 5, 3, 3, 1}, then create a freqArr
         ? {0, 1, 0, 2, 1, 1, 1}
         * Easier if all elements are non negative, and the max value is small
         */
        int[] fMap = new int[100];
        int maxEl = Integer.MIN_VALUE;
        for (Integer e : a) {
            maxEl = Math.max(maxEl, e);
            fMap[e] = ++fMap[e];
        }

        for (int i = 0; i < maxEl; i++) { // The border case of 99 means that i will go till 98
            maxSize = Math.max(maxSize, fMap[i] + fMap[i + 1]);
        }

        return maxSize;
    }
}
