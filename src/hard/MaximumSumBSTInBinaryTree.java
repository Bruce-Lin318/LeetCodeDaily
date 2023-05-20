package hard;

import util.TreeNode;

/**
 * https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/
 * 1373. 二叉搜索子树的最大键值和
 *
 * @author Lin
 * @date 2023/5/20
 */
@SuppressWarnings("ALL")
public class MaximumSumBSTInBinaryTree {
    static final int MAX = 4 * 10000 * 4 * 10000;
    static final int[] NOT_BST = new int[]{0, 0, MAX + 1};
    static final int[] EMPTY = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    private int res = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    // 返回值[树的最小值， 树的最大值， 搜索树的总和（和若大于MAX说明不是搜索树）]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return EMPTY;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[2] > MAX || left[1] >= node.val || right[2] > MAX || right[0] <= node.val) {
            return NOT_BST;
        }
        int sum = node.val + left[2] + right[2];
        res = Math.max(res, sum);
        // 空节点的边界为[max, min]矫正边界
        return new int[]{Math.min(left[0], node.val), Math.max(right[1], node.val), sum};
    }
}
