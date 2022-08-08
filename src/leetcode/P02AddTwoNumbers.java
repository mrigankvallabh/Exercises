package leetcode;

/**
 * ListNode
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int co = 0;
    ListNode sum = null;
    ListNode tNode = null;

    while (l1 != null || l2 != null) {
      int d1 = (l1 == null ? 0 : l1.val); // Get the first digit or 0
      int d2 = (l2 == null ? 0 : l2.val); // Get the first digit or 0
      int s = d1 + d2 + co; // Add the digits and the Carryover
      co = s / 10;

      ListNode cNode = new ListNode(s % 10, null);
      if (tNode == null) {
        tNode = cNode;
        sum = tNode;
      } else {
        tNode.next = cNode;
        tNode = cNode;
      }

      l1 = (l1 == null ? null : l1.next);
      l2 = (l2 == null ? null : l2.next);
    }

    // Catch the last carryover
    if (co != 0) {
      tNode.next = new ListNode(co, null);
    }

    return sum;
  }

  public static ListNode creaListNode(int n) {
    ListNode hNode = new ListNode(n % 10);
    ListNode tNode = hNode;
    for (int i = n / 10; i > 0; i /= 10) {
      tNode.next = new ListNode(i % 10);
      tNode = tNode.next;
    }
    return hNode;
  }

  @Override
  public String toString() {
    ListNode tNode = this;
    StringBuilder sb = new StringBuilder();
    while (tNode != null) {
      sb.append(tNode.val).append(" -> ");
      tNode = tNode.next;
    }
    return "Head -> " + sb.toString() + "null";
  }

}

public class P02AddTwoNumbers {
  public static void main(String[] args) {
    int n1 = 8490;
    var l1 = ListNode.creaListNode(n1);
    int n2 = 495067;
    var l2 = ListNode.creaListNode(n2);
    ListNode sumListNode = ListNode.creaListNode(n1 + n2);
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(sumListNode);
    System.out.println(ListNode.addTwoNumbers(l1, l2));
  }

}
