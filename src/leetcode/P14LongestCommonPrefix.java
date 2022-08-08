package leetcode;

public class P14LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strings = { "flower", "flow", "fl" };
    String commonPrefix = longestCommonPrefix(strings);
    System.out.println(commonPrefix);
  }

  private static String longestCommonPrefix(String[] strings) {
    if (strings.length == 0)
      return "";
    String prefix = strings[0];
    for (int i = 1; i < strings.length; i++)
      while (strings[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty())
          return "";
      }
    return prefix;
  }
}
