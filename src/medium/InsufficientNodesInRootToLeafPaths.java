package medium;

import util.TreeNode;

/**
 * https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/
 * 1080. 根到叶路径上的不足节点
 *
 * @author Lin
 * @date 2023/5/22
 */
public class InsufficientNodesInRootToLeafPaths {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root, limit, 0);
        return root.left == null && root.right == null && root.val < limit ? null : root;
    }

    private int dfs(TreeNode node, int limit, int sum) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int left = dfs(node.left, limit, sum + node.val);
        int right = dfs(node.right, limit, sum + node.val);
        int res = Math.max(left, right);

        if (left != Integer.MIN_VALUE && left + sum + node.val < limit) {
            node.left = null;
        }
        if (right != Integer.MIN_VALUE && right + sum + node.val < limit) {
            node.right = null;
        }
        return node.val + (res == Integer.MIN_VALUE ? 0 : res);
    }

}
