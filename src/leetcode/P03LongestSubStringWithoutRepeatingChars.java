package leetcode;

import java.util.HashSet;
import java.util.Set;

public class P03LongestSubStringWithoutRepeatingChars {
  public static void main(String[] args) {
    String testString = "pwwkew";
    int l = lengthOfLongestSubstring(testString);
    System.out.println(l);
  }

  private static int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty())
      return 0;
    int mxSize = 0;
    int wStart = 0;
    int wEnd = 0;
    Set<Character> unique = new HashSet<>(s.length());
    // 012345
    // PWWKEW
    while (wEnd < s.length()) {
      char c = s.charAt(wEnd);
      while (unique.contains(c)) { // 1. Has the character been seen before?
        /*
         * If seen before, clear all the seen characters
         * by moving wStart forward.
         * This is basically emptying the set as we already know the max size till
         * this point in String
         */
        unique.remove(s.charAt(wStart));
        wStart++;
      }
      unique.add(c); // 2. Add to the set if not seen before
      mxSize = Math.max(mxSize, wEnd - wStart + 1); // Compare max
      ++wEnd;
    }

    return mxSize;

  }
}
