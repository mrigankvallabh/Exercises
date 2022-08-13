package hackerrank;

import java.util.Arrays;

public class TwoChars {
  public static void main(String[] args) {
    String s = "tlymrvjcylhqifsqtyyzfaugtibkkghfhyzxqbsizkjguqlqwwetyofqihtpkmpdlgthfybfhhmjerjdkybwppwrdapirukcshkpngayrdruanjtziknnwxmsjpnuswllymhkmztsrcwwzmlbcoakswwffveobbvzinkhnmvwqhpfednhsuzmffaebi";
    System.out.println(alternate(s));
  }

  public static int alternate(String s) {
    int len = 0;

    int[] distinctChars = s.chars().distinct().toArray();
    // Remove two chars at a time
    for (int i = 0; i < distinctChars.length; i++) {
      for (int j = i + 1; j < distinctChars.length; j++) {
        int c1 = distinctChars[i];
        int c2 = distinctChars[j];
        int[] filteredArray = s.chars().filter(cint -> cint == c1 || cint == c2).toArray();
        // check is array alternate
        if (isAlt(filteredArray)) {
          System.out.println(Arrays.toString(filteredArray));
          System.out.println(filteredArray.length);
          len = Math.max(len, filteredArray.length);
        }
      }
    }
    return len;
  }

  private static boolean isAlt(int[] arr) {
    // 99, 120, 99, 120, 99, 99
    if (arr.length <= 1)
      return false; // 1 element cannot be alternating
    if (arr[0] == arr[1])
      return false; // 2 sized array must be different
    for (int i = 2; i < arr.length; i += 2) {
      if (arr[i] != arr[0]) // Check every odd placed element with 1st element
        return false;

      if (i + 1 < arr.length && arr[i + 1] != arr[1])
        return false;
    }
    return true;
  }
}
