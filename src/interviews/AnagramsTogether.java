package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsTogether {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "tac", "god", "act"};
        printAnagrams(words);
    }

    private static void printAnagrams(String[] words) {
        Map<String, List<String>> strMap = new HashMap<>();

        for (String w : words) {
            int[] array = w.chars().sorted().toArray();
            String key = new String(array, 0, array.length);
            if (!strMap.containsKey(key)) {
                List<String> tList = new ArrayList<>();
                strMap.put(key, tList);
            }
            strMap.get(key).add(w);
        }

        String[] array = strMap.values().stream().flatMap(Collection::stream).toList().toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
