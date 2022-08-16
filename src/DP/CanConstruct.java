package DP;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }, null));
    System.out
        .println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            new String[] { "e", "ee", "eee", "eeee", "eeeee" }, null));

    System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }, null));
    System.out
        .println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            new String[] { "e", "ee", "eee", "eeee", "eeeee" }, null));
  }

  public static boolean canConstruct(String targetString, String[] words, Map<String, Boolean> memo) {
    if (memo == null)
      memo = new HashMap<>();

    if (memo.containsKey(targetString))
      return memo.get(targetString);

    if (targetString.isEmpty())
      return true;

    for (String word : words) {
      if (targetString.startsWith(word)) {
        String suffix = targetString.substring(word.length(), targetString.length());
        if (canConstruct(suffix, words, memo) == true) {
          memo.put(targetString, true);
          return memo.get(targetString);
        }
      }
    }

    memo.put(targetString, false);
    return memo.get(targetString);
  }

  public static int countConstruct(String targetString, String[] words, Map<String, Integer> memo) {
    if (memo == null)
      memo = new HashMap<>();

    if (memo.containsKey(targetString))
      return memo.get(targetString);

    if (targetString.isEmpty())
      return 1;

    for (String word : words) {
      if (targetString.startsWith(word)) {
        String suffix = targetString.substring(word.length(), targetString.length());
        int numWaysSuffix = countConstruct(suffix, words, memo);
        int totalCount = memo.getOrDefault(targetString, 0);
        totalCount += numWaysSuffix;
        memo.put(targetString, totalCount);
        return memo.get(targetString);
      }
    }

    memo.put(targetString, 0);
    return memo.get(targetString);
  }

}
