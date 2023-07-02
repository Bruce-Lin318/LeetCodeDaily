package medium;


import medium.MergeInBetweenLinkedLists.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 2. 两数相加
 *
 * @author Lin
 * @date 2023/7/2
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = new ListNode();
    ListNode cur = root;
    int carr = 0;
    while (l1 != null || l2 != null || carr != 0) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      if (carr != 0) {
        sum += carr;
      }
      carr = sum > 9 ? 1 : 0;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
    }
    return root.next;
  }

}
