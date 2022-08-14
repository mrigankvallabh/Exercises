package DP;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {
  public static void main(String[] args) {
    System.out.println(fib(92));
  }

  private static long fib(int n) {
    Map<Integer, Long> memo = new HashMap<>();

    return fib(n, memo);
  }

  private static long fib(int n, Map<Integer, Long> memo) {
    if (memo.containsKey(n))
      return memo.get(n);
    if (n <= 2)
      return 1;
    memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
    return memo.get(n);
  }
}
