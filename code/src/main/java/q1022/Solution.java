package q1022;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        int toReturn = 0;
        for (int i : list) {
            toReturn += i;
        }
        return toReturn;
    }

    private void sum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int temp = sum * 2 + root.val;
        if (root.left == null && root.right == null) {
            list.add(temp);
        }
        sum(root.left, temp);
        sum(root.right, temp);
    }
}