package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DenseRank {
    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(new Integer[] { 100, 100, 50, 40, 40, 20, 10 }); // Sorted Desc
        List<Integer> player = Arrays.asList(new Integer[] { 5, 25, 50, 120 }); // Sorted Asc

        List<Integer> result = new ArrayList<>();

        for (Integer p : player) {
            int s = 0;
            int t = ranked.size() - 1;
            int m = -1;
            // Binary search to peg the last index to check
            while (s <= t) {
                m = (s + t) / 2;
                if (ranked.get(m) <= p) {
                    t = m - 1;
                } else {
                    s = m + 1;
                }
            }

            int lastIndexToCheck = m + 1;

            int i = 0;
            int rank = 1;
            int lastSeen = Integer.MIN_VALUE;
            while (i < lastIndexToCheck) {
                if (ranked.get(i) > p && ranked.get(i) != lastSeen) {
                    rank++;
                    lastSeen = ranked.get(i);
                }
                if (ranked.get(i) <= p)
                    break;
                i++;
            }
            result.add(rank);
        }
        System.out.println(result);
    }
}
