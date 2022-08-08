package leetcode;

// Easy
public class P09PalindromeNumber {
  public static void main(String[] args) {
    final long x = 9987667899L;
    System.out.println(isPalindrome(x));
  }

  private static boolean isPalindrome(long x) {
    if (x < 0)
      return false;

    if (x >= 0 && x <= 9)
      return true;

    long rx = 0;
    for (long i = x; i > 0; i /= 10)
      rx = rx * 10 + i % 10;

    return x == rx;
  }

}
