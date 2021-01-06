package q230;

import common.TreeNode;

public class Solution {
    private int rank;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return;
        }
        traverse(treeNode.left, k);
        rank++;
        if (k == rank) {
            result = treeNode.val;
            return;
        }
        traverse(treeNode.right, k);
    }
}