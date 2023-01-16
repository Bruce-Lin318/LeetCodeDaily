package easy;

import util.TreeNode;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 * 101. 对称二叉树
 *
 * @author Lin
 * @date 2023/1/16
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        return process(left.left, right.right) && process(left.right, right.left);
    }
}
