package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sorter {
    /**
     *
     */
    private static final int MAX_ASSOC = 100;

    public static void main(String[] args) {
        List<Integer> arr = List.of(
                63, 25, 73, 1, 98, 73, 56, 84, 86, 57,
                16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83,
                89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59,
                10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27,
                32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24,
                87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50,
                30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48,
                33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75,
                13, 87, 70, 33);

        List<Integer> sortedArr = countingSort(arr);

        System.out.println(sortedArr);

        List<List<String>> sArr = List.of(
                List.of("1", "e"),
                List.of("2", "a"),
                List.of("1", "b"),
                List.of("3", "a"),
                List.of("4", "f"),
                List.of("1", "f"),
                List.of("2", "a"),
                List.of("1", "e"),
                List.of("1", "b"),
                List.of("1", "c"));

        countSort(new ArrayList<>(
                sArr
                        .stream()
                        .map(is -> new ArrayList<>(is))
                        .toList()));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>();
        int[] freq = new int[100];
        for (int e : arr) {
            freq[e]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            for (int j = 0; j < freq[i]; j++) {
                sortedArr.add(i);
            }
        }

        return sortedArr;

    }

    public static void countSort(List<List<String>> sArr) {

        int halfSize = sArr.size() /2;
        StringBuilder[] sortedArr = new StringBuilder[MAX_ASSOC]; // Cannot have more than 100 different associations
        for (int i = 0; i < MAX_ASSOC; i++) {
            sortedArr[i] = new StringBuilder();
        }

        for (int i = 0; i < sArr.size(); i++) {
            List<String> pair = sArr.get(i);
            int index = Integer.parseInt(pair.get(0));
            String val = (i < halfSize) ? "-" : pair.get(1);
            sortedArr[index]
                    .append(val + " ");
        }
        
        // for (int i = 1; i < MAX_ASSOC; i++) {
        //     sortedArr[0].append(sortedArr[i]);
        // }
        System.out.println(sortedArr[0]);
        var fsb = new StringBuilder();
        Stream.of(sortedArr).filter(s -> !s.isEmpty()).forEach(s -> fsb.append(s));
        System.out.println(fsb);
    }
}
