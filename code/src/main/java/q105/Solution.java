package q105;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pre_start, int pre_end,
                               int[] inorder, int in_start, int in_end) {
        if (pre_end < pre_start || in_start > in_end) {
            return null;
        }
        int value = preorder[pre_start];
        int index = in_start;
        for (int i = index; i <= in_end; i++) {
            if (value == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - in_start;
        TreeNode root = new TreeNode(value);
        root.left = buildTree(preorder, pre_start + 1, pre_start + leftSize, inorder, index - leftSize, index - 1);
        root.right = buildTree(preorder, pre_start + leftSize + 1, pre_end, inorder, index + 1, in_end);
        return root;
    }
}