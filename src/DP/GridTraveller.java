package DP;

import java.util.HashMap;

public class GridTraveller {
  public static void main(String[] args) {
    System.out.println(gridTraveller(18, 18));
  }

  private static long gridTraveller(int rows, int cols) {
    var memo = new HashMap<Integer, Long>();
    return gridTraveller(rows, cols, memo);
  }

  private static long gridTraveller(int rows, int cols, HashMap<Integer, Long> memo) {
    int key = hash(rows, cols);
    if (memo.containsKey(key))
      return memo.get(key);
    if (rows == 0 || cols == 0)
      return 0;
    if (rows == 1 || cols == 1)
      return 1;
    memo.put(
        key,
        gridTraveller(rows - 1, cols, memo) + // move down
        // gridTraveller(rows - 1, cols - 1, memo) + // move diagonal
            gridTraveller(rows, cols - 1, memo)); // move right
    return memo.get(key);
  }

  /**
   * Returns a unique hash based on (i, j) such that hash(i, j) = hash(j, i)
   * 
   * @param rows
   * @param cols
   * @return Hash value: (max(i, j) * max (i, j) + 1) / 2 + min(i, j)
   */
  private static int hash(int rows, int cols) {
    int mx = Math.max(rows, cols);
    int mn = Math.min(rows, cols);
    return mx * (mx + 1) / 2 + mn;
  }
}
