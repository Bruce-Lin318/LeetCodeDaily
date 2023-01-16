package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 *
 * @author Lin
 * @date 2023/1/16
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    private void process(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        process(root.left, res);
        res.add(root.val);
        process(root.right, res);
    }

}
