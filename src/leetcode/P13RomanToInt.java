package leetcode;

// Easy
public class P13RomanToInt {
  public static void main(String[] args) {
    System.out.println(romanToInt1("MCMXCIV"));
  }

  @SuppressWarnings("unused")
  private static int romanToInt(String romanNum) {
    int n = 0;
    int pd = Integer.MAX_VALUE;
    for (char c : romanNum.toCharArray()) {
      int d = switch (c) {
        case 'I' -> 1;
        case 'V' -> 5;
        case 'X' -> 10;
        case 'L' -> 50;
        case 'C' -> 100;
        case 'D' -> 500;
        case 'M' -> 1000;
        default -> 0;
      };

      n += d;
      if (d > pd)
        n -= (2 * pd);

      pd = d;

    }
    return n;
  }

  private static int romanToInt1(String s) {
    int n = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      int d = switch (c) {
        case 'I' -> 1;
        case 'V' -> 5;
        case 'X' -> 10;
        case 'L' -> 50;
        case 'C' -> 100;
        case 'D' -> 500;
        case 'M' -> 1000;
        default -> 0;
      };

      if (d * 4 < n)
        n -= d;
      else
        n += d;
    }
    return n;
  }

}
