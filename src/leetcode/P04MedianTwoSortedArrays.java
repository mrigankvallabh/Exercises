package leetcode;

public class P04MedianTwoSortedArrays {

  public static void main(String[] args) {
    int[] n1 = { 1, 2 };
    int[] n2 = { 3, 4 };
    double m = findMedianSortedArraysFast(n1, n2);
    System.out.println(m);
  }

  @SuppressWarnings("unused")
  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double median = 0.0;
    /*
     * 1. Merge the Sorted Arrays
     * 2. find median of the sorted Array
     * [2, 4, 5, 6, 7, 9], [0, 4, 5, 6, 7]
     */
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    int n1 = nums1.length;
    int n2 = nums2.length;
    int[] mergednums = new int[n1 + n2];

    while (i1 < n1 && i2 < n2) {
      if (nums1[i1] < nums2[i2]) {
        mergednums[k++] = nums1[i1];
        i1++;
      } else {
        mergednums[k++] = nums2[i2];
        i2++;
      }
    }
    while (i1 < n1) {
      mergednums[k++] = nums1[i1];
      i1++;
    }
    while (i2 < n2) {
      mergednums[k++] = nums2[i2];
      i2++;
    }

    // System.out.println(Arrays.toString(mergednums));
    int n = mergednums.length;
    median = (n % 2 != 0) ? mergednums[n / 2] : (mergednums[n / 2] + mergednums[n / 2 - 1]) / 2.0;
    return median;
  }

  private static double findMedianSortedArraysFast(int[] nums1, int[] nums2) {
    // [2, 4, 5, 6, 7, 9], [0, 4, 5, 6, 7]
    int[] a;
    int[] b;

    if (nums1.length <= nums2.length) {
      a = nums1;
      b = nums2;
    } else {
      a = nums2;
      b = nums1;
    }
    int n = a.length + b.length; // Total size of the merged array: 11
    int m = (a.length + b.length) / 2; // Number of elements expected before median: 5

    int la = 0;
    int ra = a.length - 1; // 4
    int mida;
    int midb;
    int aLeft;
    int aRight;
    int bLeft;
    int bRight;

    while (true) {
      mida = (la + ra) / 2; // 2
      midb = m - mida - 1 - 1; // 5 - 2 - 2 = 1
      aLeft = mida < 0 ? Integer.MIN_VALUE : a[mida];
      aRight = (mida + 1 < a.length) ? a[mida + 1] : Integer.MAX_VALUE;
      bLeft = midb < 0 ? Integer.MIN_VALUE : b[midb];
      bRight = (midb + 1 < b.length) ? b[midb + 1] : Integer.MAX_VALUE;
      if (aLeft <= bRight && bLeft <= aRight) {
        if (n % 2 == 0) {
          return Math.min(aRight, bRight) * 1.0;
        } else {
          return (Math.max(aLeft, bLeft) + Math.max(aRight, bRight)) / 2.0;
        }
      } else if (aLeft > bRight) {
        ra = mida - 1;
      } else {
        la = mida + 1;
      }
    }
  }

}
