package offer32_3;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> toReturn = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = toReturn.size();
            boolean fromLeft = size % 2 == 0;
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode node = nodes.poll();
                if (fromLeft) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
            toReturn.add(temp);
        }
        return toReturn;
    }
}

