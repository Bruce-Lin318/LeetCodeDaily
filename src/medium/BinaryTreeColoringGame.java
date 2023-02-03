package medium;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/binary-tree-coloring-game/
 * 1145. 二叉树着色游戏
 *
 * @author Lin
 * @date 2023/2/3
 */
public class BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root.val == x) {
            return getCount(root.left) != getCount(root.right);
        }
        TreeNode first = null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            first = deque.poll();
            if (first.val == x) {
                break;
            }
            if (first.left != null) {
                deque.offer(first.left);
            }
            if (first.right != null) {
                deque.offer(first.right);
            }
        }
        int left = getCount(first.left);
        int right = getCount(first.right);
        // 要么拿先手的父节点，子节点全部归先手
        // 要么拿先手的子节点，后手的兄弟节点和父节点全部归先手
        // 有一种情况赢即为必赢
        return left > n / 2 || right > n / 2 || (left + right + 1) <= n / 2;
    }

    private int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getCount(node.left) + getCount(node.right);
    }
}
