package medium;

import util.TreeNode;

/**
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 * 2331. 计算布尔二叉树的值
 *
 * @author Lin
 * @date 2023/2/6
 */
public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.val <= 1) {
            return root.val == 1;
        }
        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
