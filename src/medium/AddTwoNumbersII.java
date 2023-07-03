package medium;

import java.util.Stack;
import util.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 * 445. 两数相加 II
 *
 * @author Lin
 * @date 2023/7/3
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode l3 = addTwo(l1, l2, 0);
        return reverseList(l3);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null)
            return carry != 0 ? new ListNode(carry) : null;
        if (l1 == null) {
            l1 = l2;
            l2 = null;
        }
        carry += l1.val + (l2 != null ? l2.val : 0);
        l1.val = carry % 10;
        l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), carry / 10); // 进位
        return l1;
    }

}
