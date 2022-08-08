package hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Find most expensive buy of a keyboard and a USB under a given budget
 */
public class ElectronicsShop {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String[] bnm = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    int b = Integer.parseInt(bnm[0]);

    int n = Integer.parseInt(bnm[1]);

    int m = Integer.parseInt(bnm[2]);

    int[] keyboards = new int[n];

    String[] keyboardsItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
      int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
      keyboards[keyboardsItr] = keyboardsItem;
    }

    int[] drives = new int[m];

    String[] drivesItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int drivesItr = 0; drivesItr < m; drivesItr++) {
      int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
      drives[drivesItr] = drivesItem;
    }

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1
     * if she can't purchase both items
     */

    int moneySpent = getMoneySpent(keyboards, drives, b);

    System.out.println(String.valueOf(moneySpent));
    scanner.close();
  }

  private static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    /*
     * b = 10
     * k = [8 2 7 5 4] = [8 7 5 4 2]
     * d = [3 7 1] = [1 3 7]
     * here checking order should be 8 + 1, 7 + 3, 5 + 7, ...
     */
    Arrays.sort(keyboards);
    Arrays.sort(drives);
    int ans = -1;
    int maxP = -1;

    for (int i = keyboards.length - 1, j = 0; i >= 0; i--) { // ? Go Descending, and initialize j = 0 here
      for (; j < drives.length; j++) { // ? Go Ascending
        if (keyboards[i] + drives[j] > b) // break if beyond budget
          break;
        if (keyboards[i] + drives[j] > maxP) // update max price
          maxP = keyboards[i] + drives[j];
      }
      ans = Math.max(ans, maxP);
    }

    return ans;
  }
}
