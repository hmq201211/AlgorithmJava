package q652;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


class Solution {
    private final HashMap<String, Integer> counter = new HashMap<>();
    private LinkedList<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        describe(root);
        return result;
    }

    private String describe(TreeNode treeNode) {
        if (treeNode == null) {
            return "#";
        }
        String left = describe(treeNode.left);
        String right = describe(treeNode.right);
        String self = treeNode.val + "," + left + "," + right;
        int duplicate = 0;
        if (counter.get(self) != null) {
            duplicate = counter.get(self);
        }
        if (duplicate == 1) {
            result.add(treeNode);
        }
        counter.put(self, duplicate + 1);
        return self;
    }
}