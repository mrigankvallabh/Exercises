package hackerrank;

import java.math.BigInteger;
import java.util.List;

public class Trial {
    public static void main(String[] args) {
        List<Integer> h = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
        System.out.println(designerPdfViewer(h, "tornado"));
        h = List.of(0, 0, 1, 0);
        jumpingOnClouds(h.stream().mapToInt(Integer::intValue).toArray(), 2);
        extraLongFactorials(3);
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        int area = 0;

        List<Integer> intChars = word
                .chars()
                .map(i -> i - 'a')
                .boxed()
                .toList();

        int maxH = 0;
        for (Integer i : intChars) {
            maxH = Math.max(maxH, h.get(i));
        }
        area = maxH * intChars.size();
        return area;
    }

    private static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int n = c.length;
        int currPos = 0;
        if (k == 0) return e;
        do {
            currPos = (currPos + k) % n;
            System.out.println(currPos);
            e--;
            if (c[currPos] == 1) {
                e -= 2;
            }
        } while (currPos != 0);
        System.out.println("Energy Left: " + e);
        return e;
    }

    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }


}
