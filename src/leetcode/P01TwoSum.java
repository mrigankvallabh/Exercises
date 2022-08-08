package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Easy
public final class P01TwoSum {
  public static final void main(String[] args) {
    final int[] nums = { 2, 7, 11, 15 };
    final int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }

  private static final int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> lookupMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      final int reqNum = target - nums[i];
      if (lookupMap.containsKey(reqNum)) {
        return new int[] { lookupMap.get(reqNum), i };
      } else {
        lookupMap.put(nums[i], i);
      }
    }
    return null;
  }

}
