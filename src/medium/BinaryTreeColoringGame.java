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
        TreeNode one = null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            one = deque.poll();
            if (one.val == x) {
                break;
            }
            if (one.left != null) {
                deque.offer(one.left);
            }
            if (one.right != null) {
                deque.offer(one.right);
            }
        }
        int left = getCount(one.left);
        int right = getCount(one.right);
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
