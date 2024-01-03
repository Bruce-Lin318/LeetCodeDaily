package medium;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/
 * 2487. 从链表中移除节点
 *
 * @author Lin
 * @date 2024/1/3
 */
public class RemoveNodeFromLinkedList {
    public ListNode removeNodes1(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int max = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            max = Math.max(max, list.get(i));
            list.set(i, max);
        }

        ListNode pre = new ListNode();
        pre.next = head;
        cur = pre;
        for (int i = 0; i < list.size(); i++) {
            if (cur.next.val < list.get(i)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public ListNode removeNodes2(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        int max = 0;
        while (cur != null && cur.next != null) {
            max = Math.max(max, cur.val);
            if (cur.next.val < max) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
