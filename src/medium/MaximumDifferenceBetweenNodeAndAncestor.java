package medium;

import util.TreeNode;

/**
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 * 1026. 节点与其祖先之间的最大差值
 *
 * @author Lin
 * @date 2023/4/18
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    private int ans;
    public int maxAncestorDiff(TreeNode root) {
        process(root, 0, Integer.MAX_VALUE);
        return ans;
    }

    private void process(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        ans = Math.max(ans, Math.abs(max - min));
        process(root.left, max, min);
        process(root.right, max, min);
    }
}
