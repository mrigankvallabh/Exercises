package leetcode;

public class P14LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strings = { "flower", "flow", "fl" };
    String commonPrefix = longestCommonPrefix(strings);
    System.out.println(commonPrefix);
  }

  private static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty())
          return "";
      }
    }
    return prefix;
  }
}
