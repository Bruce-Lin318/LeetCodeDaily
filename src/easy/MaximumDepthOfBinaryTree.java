package easy;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度
 *
 * @author Lin
 * @date 2023/1/16
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int cur = 1;
        int next = 0;
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (--cur == 0) {
                res++;
                cur = next;
                next = 0;
            }
        }
        return res;
    }
}
