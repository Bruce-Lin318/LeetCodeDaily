package medium;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 * 1669. 合并两个链表
 *
 * @author Lin
 * @date 2023/1/30
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1.next;
        ListNode cur = list1;
        for (int i = 0; i < a - 1; i++) {
            cur = start;
            start = start.next;
        }
        cur.next = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        for (int i = 0; i <= b - a; i++) {
            start = start.next;
        }
        cur.next = start;
        return list1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
