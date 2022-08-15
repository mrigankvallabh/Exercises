package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        boolean canSum = canSum(300, new int[] { 7, 14 });
        int[] howSum = howSum(16, new int[] { 6, 7, 4, 2, 5, 9 });
        int[] bestSum = bestSum(16, new int[] { 6, 7, 4, 2, 5, 9 });
        System.out.println(canSum);
        System.out.println(Arrays.toString(howSum));
        System.out.println(Arrays.toString(bestSum));
    }

    private static int[] bestSum(int targetSum, int[] numbers) {
        return bestSum(targetSum, numbers, new HashMap<Integer, List<Integer>>());
    }

    private static int[] bestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum) == null ? null : memo.get(targetSum).stream().mapToInt(i -> i).toArray();
        }

        if (targetSum == 0) {
            return new int[] {};
        }

        if (targetSum < 0) {
            return null;
        }

        int[] shortestPath = null;

        for (int n : numbers) {
            int[] bestSumRemainder = bestSum(targetSum - n, numbers, memo);
            if (bestSumRemainder != null) {
                int[] currentBest = new int[bestSumRemainder.length + 1];
                System.arraycopy(bestSumRemainder, 0, currentBest, 0, bestSumRemainder.length);
                currentBest[bestSumRemainder.length] = n;
                if (shortestPath == null || currentBest.length < shortestPath.length) {
                    shortestPath = currentBest;
                }
            }
        }

        if (shortestPath != null) {
            memo.put(targetSum, Arrays.stream(shortestPath).boxed().toList());
        } else {
            memo.put(targetSum, null);
        }

        return memo.get(targetSum) == null ? null : memo.get(targetSum).stream().mapToInt(i -> i).toArray();
    }

    private static int[] howSum(int targetSum, int[] numbers) {
        return howSum(targetSum, numbers, new HashMap<Integer, List<Integer>>());
    }

    private static int[] howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum) == null ? null : memo.get(targetSum).stream().mapToInt(i -> i).toArray();
        if (targetSum == 0)
            return new int[] {};
        if (targetSum < 0)
            return null;

        for (int n : numbers) {
            int[] howSumRemainder = howSum(targetSum - n, numbers, memo);
            if (howSumRemainder != null) {
                List<Integer> currentList = new ArrayList<>(Arrays.stream(howSumRemainder).boxed().toList());
                currentList.add(n);
                memo.put(targetSum, currentList);
                return memo.get(targetSum).stream().mapToInt(i -> i).toArray();
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        return canSum(targetSum, numbers, new HashMap<Integer, Boolean>());
    }

    /**
     * Finds whether target sum can be achieved by using numbers from an array. A
     * number can be used any number of time
     * <p>
     * <em>Dynamic Programming technique</em>
     * </p>
     * 
     * @param targetSum the sum to achieve
     * @param numbers   array of non negative numbers
     * @param memo      a lookup table for caching intermediate results
     * @return true if the sum can be achieved; false otherwise
     */
    private static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;

        for (int n : numbers) {
            boolean canSumRemainder = canSum(targetSum - n, numbers, memo);
            if (canSumRemainder) {
                memo.put(targetSum, true);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, false);
        return memo.get(targetSum);
    }

}
