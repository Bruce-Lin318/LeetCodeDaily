package medium;

import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 * 1019. 链表中的下一个更大节点
 *
 * @author Lin
 * @date 2023/4/10
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(Node head) {
        Stack<int[]> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int index = -1;
        while (head != null) {
            index++;
            res.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < head.value) {
                res.set(stack.pop()[1], head.value);
            }
            stack.push(new int[]{head.value, index});
            head = head.next;
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
